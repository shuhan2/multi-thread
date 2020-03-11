package synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumClassTest {

  @Test
  public void should_return_1000_when_increment_1000_times() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(3);

    SumClass summation = new SumClass();

    IntStream.range(0, 1000)
        .forEach(count -> service.submit(() -> summation.calculate()));

    service.shutdown();
    service.awaitTermination(1, TimeUnit.MILLISECONDS);
    assertEquals(1000, summation.getSum());
  }

  @Test
  public void name() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(3);
    SharedObject sharedObject = new SharedObject();
    IntStream.range(0, 1000)
        .forEach(count -> service.submit(() -> sharedObject.incrementCount()));

    service.awaitTermination(1000, TimeUnit.MILLISECONDS);
    assertEquals(1000, sharedObject.getCount());

  }

}