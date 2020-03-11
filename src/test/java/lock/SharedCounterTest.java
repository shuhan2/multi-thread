package lock;

import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharedCounterTest {

  ReentrantLock lock = new ReentrantLock();
  int counter = 0;

  public void add() {
    lock.lock();
    try {
      counter++;
    } finally {
      lock.unlock();
    }
  }

  public int getCounter() {
    lock.lock();
    try {
      return counter;
    } finally {
      lock.unlock();
    }
  }

  @Test
  void name() {

  }
}