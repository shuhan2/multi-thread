package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddMinusCounterTest {

  @Test
  void should_return_0() throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    AddMinusCounter addMinusCounter = new AddMinusCounter();

    IntStream.range(0, 100000).forEach(i -> executorService.submit(() -> {
      addMinusCounter.add();
      addMinusCounter.minus();
    }));


    executorService.shutdown();
    executorService.awaitTermination(100, TimeUnit.MILLISECONDS);

    assertEquals(0, addMinusCounter.getCounter());
  }
}