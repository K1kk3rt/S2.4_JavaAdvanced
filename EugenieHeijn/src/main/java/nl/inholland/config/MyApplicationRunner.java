package nl.inholland.config;

import nl.inholland.model.Address;
import nl.inholland.model.ApiKey;
import nl.inholland.model.Person;
import nl.inholland.repository.AddressRepository;
import nl.inholland.repository.ApiKeyRepository;
import nl.inholland.repository.PersonRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.lang.String;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private AddressRepository addressRepository;
    private PersonRepository personRepository;
    private ApiKeyRepository keyRepository;

    public MyApplicationRunner(AddressRepository addressRepository, PersonRepository personRepository, ApiKeyRepository keyRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
        this.keyRepository = keyRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //get addresses
        Files.lines(Paths.get("src/main/resources/address.csv"))
                .forEach(
                        line -> addressRepository.save(
                                new Address(
                                        Long.parseLong(line.split(",")[0]),
                                    line.split(",")[1],
                                    line.split(",")[2],
                                    line.split(",")[3],
                                        line.split(",")[4]

                                        )));

        addressRepository.findAll()
                .forEach(System.out::println);

       Files.lines(Paths.get("src/main/resources/person.csv"))
                .forEach(
                        line -> personRepository.save(
                                new Person(
                                        line.split(",")[1],
                                        line.split(",")[2],
                                        line.split(",")[3],
                                        new Random().nextInt(100)
                                )));

        addressRepository.findAll()
                .forEach(System.out::println);

        for (String s : Arrays.asList(new String[]{"5962A7199EBCA21A48ABAE8E8921A", "A21896CC68CF6822A8F4A9EC2D6A8", "57CB8558ADF9CE22FEE4DF2A34B86"})) {
            keyRepository.save(new ApiKey(s));
        }

        keyRepository.findAll()
                .forEach(System.out::println);


    }
}
