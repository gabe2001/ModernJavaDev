// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.classes;

/**
 * {@code com.hpe.training.sealed.classes}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public non-sealed abstract class GoodsVehicle extends Vehicle
{
   public GoodsVehicle(int capacity, Units units)
   {
      super(capacity, units);
   }
}
