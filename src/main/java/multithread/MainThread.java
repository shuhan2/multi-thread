package multithread;

public class MainThread {

  public static void main(String[] args) throws InterruptedException {

    //way 1
    long before1Time = System.nanoTime();
    Thread aThread = new Thread(new AThread());
    Thread bThread = new Thread(new BThread());
    aThread.start();
    aThread.join();
    bThread.start();
    bThread.join();
    System.out.println("Main thread");
    System.out.println(String.format("Way1： %d",System.nanoTime() - before1Time));

    //way 2
    long before2Time = System.nanoTime();
    System.out.println("A Thread");
    System.out.println("B Thread");
    System.out.println("Main Thread");
    System.out.println(System.nanoTime() - before2Time);
  }

}
