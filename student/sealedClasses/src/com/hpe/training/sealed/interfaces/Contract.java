// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.sealed.interfaces;


/**
 * {@code com.hpe.training.sealed.interfaces}
 *
 * @author Gabriel Inäbnit - 2022-11-16
 */
public sealed interface Contract permits FullTimer, PartTimer, Consultant
{

   long getEffectiveSalary();

}
