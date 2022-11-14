// (c) Copyright 2022 Hewlett Packard Enterprise Development L.P.
package com.hpe.training.language;

//@FunctionalInterface
//NOTE: Cannot annotate this as a FunctionalInterface because this interface
//      implements more than one abstract method.
public interface TemperatureConverter
{
   private double random()
   {
      return 200 * Math.random() - 100;
   }

   default double getCelsius()
   {
      return random();
   }

   default double getFarenheit()
   {
      return random() * 9 / 5 + 32;
   }

   default double getKelvin()
   {
      return random() + 273.15;
   }

   String getCelsiusFormatted();
   String getFarenheitFormatted();
   String getKelvinFormatted();

}
