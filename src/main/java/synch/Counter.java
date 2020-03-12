package synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Counter {

  private static int number = 0;

  public static void increment() {
    number++;


  }

  public static int getValue() {
    return number;
  }

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(1);
    IntStream.range(0, 1000).forEach(i -> executor.submit(Counter::increment));

    executor.shutdown();
    executor.awaitTermination(1000, TimeUnit.MILLISECONDS);


    System.out.println(getValue());   //1000
  }
}
