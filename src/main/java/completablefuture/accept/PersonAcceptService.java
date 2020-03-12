package completablefuture.accept;

import completablefuture.demo.AddressRepository;
import completablefuture.demo.EmailRepository;
import completablefuture.demo.Person;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class PersonAcceptService {
  private AddressRepository addressRepository;

  private EmailRepository emailRepository;

  public PersonAcceptService(AddressRepository addressRepository, EmailRepository emailRepository) {
    this.addressRepository = addressRepository;
    this.emailRepository = emailRepository;
  }

  public Person getPersonByFuture() {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CompletableFuture<String> email = supplyAsync(() -> emailRepository.provideEmail());

    CompletableFuture<String> address = supplyAsync(() -> addressRepository.provideAddress());
    String join = address.join();
    System.out.println(join);
    Person person =  new Person(email.join(), join);
    return person;
  }

}
