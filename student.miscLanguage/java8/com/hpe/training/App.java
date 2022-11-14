// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training;

/**
 * {@code com.hpe.training}
 *
 * @author Gabriel Inäbnit - 2022-11-14
 */
public class App
{

   public static void main(String... args)
   {
      final TemperatureConverterImpl tc = new TemperatureConverterImpl();

      System.out.println(tc.getCelsiusFormatted() + "C");
      System.out.println(tc.getFarenheitFormatted() + "F");
      System.out.println(tc.getKelvinFormatted() + "K");
   }

}
