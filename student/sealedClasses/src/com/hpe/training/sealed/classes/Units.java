// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.classes;

/**
 * {@code com.hpe.training.sealed.classes}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public enum Units
{

   PERSON   ("persons"),
   KILO     ("kilos"),
   TON      ("tons"),
   ;

   private String units;

   Units(final String units)
   {
      this.units = units;
   }

   @Override
   public String toString()
   {
      return units;
   }

}
