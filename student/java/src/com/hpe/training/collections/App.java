// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@code com.hpe.training}
 *
 * @author Gabriel Inäbnit - 2022-11-14
 */
public class App
{

   public static void main(String[] args)
   {

      // get a random set of numbers, not repeating
      final Set<Integer> numbers = new HashSet<>();
      for (int i = 0; i < 20; i++)
      {
         numbers.add(Math.toIntExact(Math.round(Math.random() * 100)));
      }

      final List<Defect> defects = new ArrayList<>();
      // comment next statement to test .ifPresentOrElse and dealing with empty collections
      numbers.forEach(n -> defects.add(new Defect(n, String.format("I'm defect #%d", n))));

      List<Defect> fixedList = defects.stream().sorted().toList();

      System.out.println("Defects < 50");
      fixedList
              .stream()
              .filter(d -> d.getSeverity() < 50)
              .forEach(d -> System.out.printf("Defect %d: %s%n", d.getSeverity(), d.getDescription()));

      System.out.println("Defects => 50");
      fixedList
              .stream()
              .filter(d -> d.getSeverity() >= 50)
              .forEach(d -> System.out.printf("Defect %d: %s%n", d.getSeverity(), d.getDescription()));

      System.out.println("Defect with lowest severity or none");
      fixedList
              .stream()
              .min(Defect::compareTo)
              .ifPresentOrElse(d -> System.out.printf("Defect %d: %s%n", d.getSeverity(), d.getDescription()),
                      () -> System.out.println("-1, NO DEFECTS"));

   }

}
