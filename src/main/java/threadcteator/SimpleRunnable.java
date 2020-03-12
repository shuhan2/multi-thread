package threadcteator;

import java.util.concurrent.Callable;

public class SimpleRunnable implements Runnable {

  @Override
  public void run() {

    System.out.println("SimpleRunnable");
  }
}
