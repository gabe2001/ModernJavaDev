// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.switches;

/**
 * {@code com.hpe.training.switches}
 *
 * @author Gabriel Inäbnit - 2022-11-15
 */
public record Date(int year, int month, int day)
{

   public Date
   {
      if (!isValid(year, month, day))
      {
         throw new IllegalArgumentException(
                 String.format("%04d-%02d-%02d (YYYY-MM-DD) is not a valid year", year, month, day));
      }
   }

   /**
    * Used for validating data before creating Date record.
    * It's also a utility class for general use.
    *
    * @param year  int
    * @param month int
    * @param day   int
    * @return boolean is/isn't valid date
    */
   public static boolean isValid(final int year, final int month, final int day)
   {
      boolean isValid;

      if (month < 1 || month > 12)
      {
         isValid = false;
      }
      else if (year < 0 || year > 2099)
      {
         isValid = false;
      }
      else if (day < 1)
      {
         isValid = false;
      }
      else
      {
         int maxDay = switch (month)
                 {
                    case 2 -> (isLeapYear(year)) ? 29 : 28;
                    case 4, 6, 9, 11 -> 30;
                    default -> 31;
                 };

         isValid = (day <= maxDay);
      }
      return isValid;
   }

   /**
    * @param year int
    * @return boolean is/isn´t a leap year
    */
   public static boolean isLeapYear(final int year)
   {
      return ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
   }

   /**
    * Redundant method as we're validating the data before creating the Date record
    *
    * @return boolean is/isn't a valid date
    */
   public boolean isValid()
   {
      return isValid(year, month, day);
   }

   public String daySuffix()
   {
      return switch (day)
              {
                 case 1, 21, 31 -> "st";
                 case 2, 22 -> "nd";
                 case 3, 23 -> "rd";
                 default -> "th";
              };
   }

   public String monthName()
   {
      return switch (month)
              {
                 case 1 -> "January";
                 case 2 -> "February";
                 case 3 -> "March";
                 case 4 -> "April";
                 case 5 -> "May";
                 case 6 -> "June";
                 case 7 -> "July";
                 case 8 -> "August";
                 case 9 -> "September";
                 case 10 -> "October";
                 case 11 -> "November";
                 case 12 -> "December";
                 default -> "Not Known";
                 // Should never happen
              };
   }

   public boolean isLeapYear()
   {
      return isLeapYear(year);
   }

}
