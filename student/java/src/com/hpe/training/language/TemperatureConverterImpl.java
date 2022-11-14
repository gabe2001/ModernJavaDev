// (c) Copyright 2022 Hewlett Packard Enterprise Development L.P.
package com.hpe.training.language;

public class TemperatureConverterImpl implements TemperatureConverter
{

   @Override
   public String getCelsiusFormatted()
   {
      return String.format("%.2f", getCelsius());
   }

   @Override
   public String getFarenheitFormatted()
   {
      return String.format("%.2f", getFarenheit());
   }

   @Override
   public String getKelvinFormatted()
   {
      return String.format("%.2f", getKelvin());
   }

}
