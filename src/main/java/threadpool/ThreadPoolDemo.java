package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ThreadPoolDemo {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 9; i++) {
      executorService.submit(new Task("" + i));
    }
    // 关闭线程池:
    executorService.shutdown();

  }

}
