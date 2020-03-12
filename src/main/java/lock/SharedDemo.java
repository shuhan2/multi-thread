package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SharedDemo {

  public static void main(String[] args) throws InterruptedException {

    SharedCounter sharedCounter = new SharedCounter();

    ExecutorService executor = Executors.newFixedThreadPool(5);
    IntStream.range(0, 1000).forEach(i -> executor.submit(sharedCounter::add));

    executor.shutdown();
    executor.awaitTermination(1000, TimeUnit.SECONDS);

    System.out.println(sharedCounter.getCounter());

  }

}
