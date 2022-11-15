// (c) Copyright 2022 Hewlett Packard Enterprise Development LP
package com.hpe.training.records;

import java.time.Year;

/**
 * {@code com.hpe.training.records}
 *
 * @author Gabriel Inäbnit - 2022-11-15
 */
public record Book(String title, String genre, String author, Year published, String description)
{

   public Book
   {
      if (title == null
         || title.isEmpty()
         || title.length() > 100
         || (genre != null && genre.length() > 20)
         || (author != null && author.length() > 50)
         || published == null
         || published.isAfter(Year.now())
         || (description != null && description.length() > 500)
      )
      {
         throw new IllegalArgumentException(String.format("Illegal arguments %s, %s, %s, %s, %s", title, genre,
                 author, published, description));
      }
   }

   public static class Builder
   {

      private String title, genre, author, description;
      private Year published;

      public Book build()
      {
         return new Book(title, genre, author, published, description);
      }

      public Builder title(final String title)
      {
         this.title = title;
         return this;
      }

      public Builder genre(final String genre)
      {
         this.genre = genre;
         return this;
      }

      public Builder author(final String author)
      {
         this.author = author;
         return this;
      }

      public Builder published(final Year published)
      {
          this.published = published;
          return this;
      }

      public Builder description(final String description)
      {
         this.description = description;
         return this;
      }

   }


}
