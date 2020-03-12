package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {

  public static void main(String[] args)  {
    // fork/join:
    ForkJoinTask<Integer> task = new Fibonacci(100);
    long startTime = System.currentTimeMillis();
    Integer result = ForkJoinPool.commonPool().invoke(task);
    long endTime = System.currentTimeMillis();
    System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
  }
}

class Fibonacci extends RecursiveTask<Integer> {

  final int n;
  Fibonacci(int n) {
    this.n = n;
  }

  protected Integer compute() {
    if (n <= 1) {
      return n;
    }
    Fibonacci f1 = new Fibonacci(n - 1);
    f1.fork();
    Fibonacci f2 = new Fibonacci(n - 2);
    return f2.compute() + f1.join();
  }

}
