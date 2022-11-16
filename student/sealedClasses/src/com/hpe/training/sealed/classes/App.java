// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code com.hpe.training.sealed.classes}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public class App
{

   public static void main(String... args)
   {
      final List<Vehicle> fleet = new ArrayList<>();

      fleet.add(new Car(4));
      fleet.add(new Taxi(6));
      fleet.add(new Bus(30));
      fleet.add(new LightGoodsVehicle(2000));
      fleet.add(new HeavyGoodsVehicle(10));

      fleet.forEach(System.out::println);

   }
}
