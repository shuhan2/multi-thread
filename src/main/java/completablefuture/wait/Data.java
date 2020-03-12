//package completablefuture.wait;
//
//public class Data {
//  private String packet;
//
//  // True if receiver should wait
//  // False if sender should wait
//  private boolean transfer = true;
//
//  public synchronized void send(String packet) {
//    while (!transfer) {
//      try {
//        wait();
//        System.out.println(Thread.currentThread().getState());
//      } catch (InterruptedException e)  {
//        Thread.currentThread().interrupt();
//      }
//    }
//    transfer = false;
//
//    this.packet = packet;
//    notifyAll();
//  }
//
//  public synchronized String receive() {
//    while (transfer) {
//      try {
//
//        wait();
//      } catch (InterruptedException e)  {
//        Thread.currentThread().interrupt();
//      }
//    }
//    transfer = true;
//
//    notifyAll();
//    return packet;
//  }
//
//}
