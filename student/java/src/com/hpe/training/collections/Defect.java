// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.collections;

/**
 * {@code com.hpe.training}
 *
 * @author Gabriel Inäbnit - 2022-11-14
 */
public class Defect implements Comparable<Defect>
{

   private final int severity;
   private final String description;

   public Defect(final int severity, final String description)
   {
      this.severity = severity;
      this.description = description;
   }

   @Override
   public int compareTo(Defect o)
   {
      return severity - o.severity;
   }

   public int getSeverity()
   {
      return severity;
   }

   public String getDescription()
   {
      return description;
   }

}
