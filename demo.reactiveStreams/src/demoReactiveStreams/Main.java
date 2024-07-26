package demoReactiveStreams;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Stream;

public class Main
{

   public static void main(String[] args)
   {
      demo1();
      demo2();
   }

   private static void demo1()
   {

      System.out.println("\nIn demo1()");

      // Create a publisher - let's use the SubmissionPublisher implementation class.
      SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

      // Register a subscriber.
      MySubscriber<String> subscriber = new MySubscriber<>();
      publisher.subscribe(subscriber);

      // Publish some items.
      System.out.println("Publishing items...");
      Stream.of("matthew", "mark", "luke", "john").forEach(publisher::submit);

      // Tell subscriber's we're done.
      publisher.close();

      // Consultancy loop :-)
      try
      {
         Thread.sleep(2000);
      }
      catch (InterruptedException ex)
      {
         // do nothing
      }

      System.out.printf("Subscriber consumed %d items\n", subscriber.consumedItems.size());
   }

   private static void demo2()
   {

      System.out.println("\nIn demo2()");

      // Create a publisher - let's use the SubmissionPublisher implementation class.
      SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

      // Create and register a TransformProcessor.
      MyTransformProcessor<String, Integer> transformProcessor = new MyTransformProcessor<>(s -> s.length());
      publisher.subscribe(transformProcessor);

      // Register a subscriber.
      MySubscriber<Integer> subscriber = new MySubscriber<>();
      transformProcessor.subscribe(subscriber);

      // Publish some items.
      System.out.println("Publishing items...");
      Stream.of("ole", "dole", "doffen").forEach(publisher::submit);

      // Tell subscriber's we're done.
      publisher.close();

      // Consultancy loop :-)
      try
      {
         Thread.sleep(2000);
      }
      catch (InterruptedException ex)
      {
         // do nothing
      }

      System.out.printf("Subscriber consumed %d items\n", subscriber.consumedItems.size());
   }
}