package nl.inholland.repository;

import nl.inholland.model.Address;
import nl.inholland.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
