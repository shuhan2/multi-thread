package completablefuture.demo;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class PersonService {

  private AddressRepository addressRepository;

  private EmailRepository emailRepository;

  public PersonService(AddressRepository addressRepository, EmailRepository emailRepository) {
    this.addressRepository = addressRepository;
    this.emailRepository = emailRepository;
  }

  public Person getPersonByFuture() {
    long startTime = System.nanoTime();
    CompletableFuture<String> email = supplyAsync(() -> emailRepository.provideEmail());

    //note : runAsync


    CompletableFuture<String> address = supplyAsync(() -> addressRepository.provideAddress());

    Person person =  new Person(email.join(), address.join());
    return person;
  }

  public Person getPerson() {
    long startTime = System.nanoTime();
    String email = emailRepository.provideEmail();

    String address = addressRepository.provideAddress();

    Person person =  new Person(email, address);
    System.out.println(System.nanoTime() -  startTime);
    return person;
  }
}
