package nl.inholland.service;

import nl.inholland.model.Address;
import nl.inholland.model.Person;
import nl.inholland.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
