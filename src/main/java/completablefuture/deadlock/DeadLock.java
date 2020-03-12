package completablefuture.deadlock;

public class DeadLock {

  //Friend
  static class Friend {
    private final String name;

    public Friend(String name) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }
    synchronized void bow(Friend bower) {
      System.out.format("%s has bowed to %s %s%n" ,
                        this.name, bower.getName(), Thread.currentThread());
      bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower) {
      System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                        this.name, bower.getName());
    }
  }

  public static void main(String[] args) throws InterruptedException {
    final Friend boy =
        new Friend("Boy");
    final Friend girl =
        new Friend("Girl");
    new Thread(new Runnable() {
      public void run() { boy.bow(girl); }
    }).start();

    new Thread(new Runnable() {
      public void run() { girl.bow(boy); }
    }).start();
  }

}
