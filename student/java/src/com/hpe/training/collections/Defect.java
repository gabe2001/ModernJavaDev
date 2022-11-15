// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.collections;

import java.util.Optional;

/**
 * {@code com.hpe.training}
 *
 * @author Gabriel Inäbnit - 2022-11-14
 */
public class Defect implements Comparable<Defect>
{

   private final int    severity;
   private final String description;

   public Defect(final int severity, final String description)
   {
      this.severity = severity;
      this.description = description;
   }

   /**
    *
    * @return no defect object
    */
   public static Optional<Defect> noDefect()
   {
      return Optional.of(new Defect(-1, "No Defect"));
   }

   @Override
   public int compareTo(final Defect o)
   {
      return severity - o.severity;
   }

   public int getSeverity()
   {
      return severity;
   }

   @Override
   public String toString()
   {
      return String.format("Defect %d: %s", severity, description);
   }

}
