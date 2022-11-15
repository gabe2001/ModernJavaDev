// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.switches;

import java.util.Scanner;

/**
 * {@code com.hpe.training.switches}
 *
 * @author Gabriel Inäbnit - 2022-11-15
 */
public class App
{

   public static void main(String... args)
   {
      try (final Scanner scanner = new Scanner(System.in))
      {
         int day, month, year;

         // Get a date from the user.
         System.out.print("Day: ");
         day = scanner.nextInt();

         System.out.print("Month: ");
         month = scanner.nextInt();

         System.out.print("Year: ");
         year = scanner.nextInt();

         System.out.printf("You entered %02d-%02d-%04d (DD-MM-YYYY).%n", day, month, year);

         final Date date = new Date(year, month, day);
         System.out.printf("Entered date is%s valid%n", date.isValid() ? "": "n't");

         System.out.printf("You entered a date of %s %d%s, %d%n",
                 date.monthName(),
                 date.day(),
                 date.daySuffix(),
                 date.year());
         System.out.printf("Year %d is%s a leap year", date.year(), date.isLeapYear() ? "" : "n't");
      }
      catch (final Exception e)
      {
         System.out.printf("You entered an illegal date: %s", e.getMessage());
      }
   }

}
