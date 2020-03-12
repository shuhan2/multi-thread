package completablefuture.wait;

public class GuardedBoy {
  boolean joy;
  public void achieveJoy() {
    // Simple loop guard. Wastes
    // processor time. Don't do this!
    while(!joy) {

    }
    System.out.println("Joy has been achieved!");
  }

  public synchronized void achieveJoyAndEfficiency() {
    // This guard only loops once for each special event, which may not
    // be the event we're waiting for.
    while(!joy) {
      try {
        wait();
      } catch (InterruptedException e) {}
    }
    System.out.println("Joy and efficiency have been achieved!");
  }

  public synchronized void notifyJoy() {

    //do something
    joy = true;
    notifyAll();
  }

}
