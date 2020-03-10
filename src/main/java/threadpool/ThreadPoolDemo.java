package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolDemo {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    long before1Time = System.nanoTime();
    for (int i = 0; i < 4; i++) {
      executorService.submit(new Task("" + i));
    }
    // 关闭线程池:
    executorService.shutdown();
    executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
    while (!executorService.isTerminated()) {

    }
    System.out.println(String.format("way1 %d", System.nanoTime() - before1Time));

    System.out.println(Thread.currentThread());

//    IntStream.range(0, 6).forEach(number -> new Thread(new Task("" + number)).start());


  }

}
