// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.classes;

/**
 * {@code com.hpe.training.sealed.classes}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public abstract sealed class Vehicle permits Car, GoodsVehicle, CommercialVehicle
{

   private final int   capacity;
   private final Units untis;

   public Vehicle(final int capacity, final Units units)
   {
      this.capacity = capacity;
      this.untis = units;
   }


   @Override
   public String toString()
   {
      return String.format("%s has a capacity of %d %s", this.getClass().getSimpleName(), capacity, untis);
   }

}
