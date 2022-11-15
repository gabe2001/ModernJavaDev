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
      final Scanner scanner = new Scanner(System.in);

      int day, month, year;
      String response;

      // Get a date from the user.
      System.out.print("Day: ");
      day = scanner.nextInt();

      System.out.print("Month: ");
      month = scanner.nextInt();

      System.out.print("Year: ");
      year = scanner.nextInt();

      System.out.printf("You entered %02d-%02d-%04d (DD-MM-YYYY).%n", day, month, year);

      final Date date = new Date(year, month, day);

      System.out.printf("You entered a date of %s %d%s, %d%n", Date.monthName(date.month()), date.day(),
              Date.daySuffix(date.day()), date.year());

   }

}
