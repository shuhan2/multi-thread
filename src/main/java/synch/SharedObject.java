package synch;

public class SharedObject {

  private int count = 0;

  public void incrementCount() {
    count++;
  }
  public int getCount() {
    return count;
  }

}
