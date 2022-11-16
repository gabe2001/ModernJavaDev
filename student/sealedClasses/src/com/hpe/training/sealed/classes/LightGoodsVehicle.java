// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.classes;

/**
 * {@code com.hpe.training.sealed.classes}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public class LightGoodsVehicle extends GoodsVehicle
{
   public LightGoodsVehicle(int capacity)
   {
      super(capacity, Units.KILO);
   }
}
