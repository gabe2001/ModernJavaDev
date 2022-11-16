// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.interfaces;


import java.time.Instant;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * {@code com.hpe.training.sealed.interfaces}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public record FullTimer(long annualSalary, Date renewalDate) implements Contract
{
   @Override
   public long getEffectiveSalary()
   {
      if (renewalDate.toInstant().isAfter(Instant.now()))
      {
         return Math.round(DAYS.between(Instant.now(), renewalDate.toInstant()) / 365.25 * annualSalary);
      }
      else
      {
         return 0;
      }
   }
}
