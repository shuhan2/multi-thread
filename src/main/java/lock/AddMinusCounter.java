package lock;

public class AddMinusCounter {

  private int counter = 0;

  public synchronized void add() {
    try {
      counter++;
    } finally {

    }

  }

  public synchronized void minus() {
    try {
      counter--;
    } finally {

    }
  }

  public int getCounter() {

    return counter;
  }

}
