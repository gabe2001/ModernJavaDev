// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code com.hpe.training.sealed.interfaces}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public class App
{

   private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

   public static void main(String... args) throws ParseException
   {
      final List<Contract> contracts = new ArrayList<>();

      contracts.add(new Consultant(1500, formatter.parse("2022-12-03")));
      contracts.add(new PartTimer(100, 40));
      contracts.add(new FullTimer(250000, formatter.parse("2032-08-01")));

      System.out.println("Lambdas");
      contracts.forEach(c -> System.out.printf("Worker %s makes %,d Ducats%n", c.getClass().getSimpleName(),
              c.getEffectiveSalary()));

      System.out.println("Switch Expressions");
      contracts.stream().map(App::hireOrFire).forEach(System.out::println);

   }


   private static String hireOrFire(final Contract contract)
   {
      return switch (contract)
      {
         case Consultant c -> String.format("Consultant makes %,d Ducats", c.getEffectiveSalary());
         case PartTimer p -> String.format("PartTimer makes %,d Ducats", p.getEffectiveSalary());
         case FullTimer f -> String.format("FullTimer makes %,d Ducats", f.getEffectiveSalary());
      };
   }

}
