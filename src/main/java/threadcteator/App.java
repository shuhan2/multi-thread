package threadcteator;

public class App {

  public static void main(String[] args) {
    Thread simpleThread = new SimpleThread();

    System.out.println(simpleThread.getState());
    simpleThread.start();

    System.out.println(simpleThread.getState());

//    new Thread(new SimpleRunnable()).start();

  }

}
