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
                 String.format("%d-%02d-%02d (YYYY-MM-DD) is not a valid year", year, month, day));
      }
   }

   public static boolean isValid(final Date date)
   {
      return isValid(date.year, date.month, date.day);
   }

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

   public static String daySuffix(final int day)
   {
      return switch (day)
              {
                 case 1, 21, 31 -> "st";
                 case 2, 22 -> "nd";
                 case 3, 23 -> "rd";
                 default -> "th";
              };
   }

   public static String monthName(final int month)
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

   public static boolean isLeapYear(final int year)
   {
      return ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
   }

}
