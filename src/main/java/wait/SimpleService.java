package wait;

public class SimpleService {

  //Producer-Consumer application
  //the producer, that creates the data
  //the consumers, that do some action with data
  //the consumer thread must not attempt to retrieve the data before the producer thread has delivered it
  //the producer thread must not attempt to deliver new data if the consumer hasn't retrieved the old data

  public void run() {
    SimpleMessage drop = new SimpleMessage();
    Thread produceThread = new Thread(new Producer(drop));
    produceThread.start();
    Thread consumerThread = new Thread(new Consumer(drop));
    consumerThread.start();
    try {
      produceThread.join();
      consumerThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  class SimpleMessage {

    private String message;
    private boolean isEmpty = true;

    synchronized String get() {
      while (isEmpty) {

      }
      isEmpty = true;
//      Thread.sleep(1000);
      return message;
    }

    synchronized void set(String message) {

      while (!isEmpty) {

      }
      isEmpty = false;
      this.message = message;
    }
  }

  class Producer implements Runnable {

    private SimpleMessage messageMachine;

    public Producer(SimpleMessage messageMachine) {
      this.messageMachine = messageMachine;
    }

    @Override
    public void run() {
      String[] infos = {
          "Solider",
          "Parents",
          "Happiness",
          "Work"
      };

      for (String info : infos) {
        messageMachine.set(info);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      messageMachine.set("DONE");
    }



  }

  class Consumer implements Runnable {
    private SimpleMessage messageMachine;

    public Consumer(SimpleMessage messageMachine) {
      this.messageMachine = messageMachine;
    }

    @Override
    public void run() {
      for (String message = messageMachine.get(); ! message.equals("DONE"); message = messageMachine.get()) {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.format("MESSAGE RECEIVED: %s%n", message);
      }
    }
  }

}
