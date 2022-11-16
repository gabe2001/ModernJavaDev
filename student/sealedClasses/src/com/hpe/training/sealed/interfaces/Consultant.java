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
public record Consultant(long dailyRate, Date renewalDate) implements Contract
{

   @Override
   public long getEffectiveSalary()
   {
      return (dailyRate * DAYS.between(Instant.now(), renewalDate.toInstant())) * 5 / 7;
   }

}
