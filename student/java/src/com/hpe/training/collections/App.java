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

      List<Defect> fixedSortedList = defects.stream().sorted().toList();
      // toList() calls collect(Collectors.toUnmodifiableList());

      System.out.println("Defects < 50");
      fixedSortedList
              .stream()
              .filter(d -> d.getSeverity() < 50)
              .forEach(System.out::println);

      System.out.println("Defects => 50");
      fixedSortedList
              .stream()
              .filter(d -> d.getSeverity() >= 50)
              .forEach(System.out::println);

      System.out.println("Defect with lowest severity or none");
      fixedSortedList
              .stream()
              .min(Defect::compareTo)
              .ifPresentOrElse(System.out::println, () -> System.out.println("-1, NO DEFECTS"));

      System.out.println("Defect with lowest severity Andy's solution");
      fixedSortedList
              .stream()
              .min(Defect::compareTo)
              .or(Defect::noDefect)
              .ifPresent(System.out::println);

   }

}
