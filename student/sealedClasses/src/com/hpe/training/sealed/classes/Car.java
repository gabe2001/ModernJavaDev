// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.classes;

/**
 * {@code com.hpe.training.sealed.classes}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public final class Car extends Vehicle
{
   public Car(final int capacity)
   {
      super(capacity, Units.PERSON);
   }
}
