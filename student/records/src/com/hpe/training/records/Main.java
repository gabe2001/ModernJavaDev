// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.records;

import java.time.Year;

/**
 * {@code com.hpe.training.records}
 *
 * @author Gabriel Inäbnit - 2022-11-15
 */
public class Main
{

   public static void main(String... args)
   {
      var book = new Book("Title", "Genre", "Author", Year.now(), "Description");
      System.out.println(book);

      var book1 = new Book.Builder()
              .title("I am the Dude!")
              .genre("Horror")
              .author("My, myself and I")
              .published(Year.of(1964))
              .description("Brace yourself for this hell of a ride")
              .build();
      System.out.println(book1);

      Book book2 = new Book.Builder()
              .title("Two Thousand")
              .published(Year.of(2000))
              .build();
      System.out.println(book2);

      Book book3 = new Book.Builder()
              .title("Science Fiction")
              .published(Year.of(3000))
              .build();
      System.out.println(book3);
   }

}
