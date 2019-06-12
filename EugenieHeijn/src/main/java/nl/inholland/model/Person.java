package nl.inholland.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table
public class Person {

    @Id
    @SequenceGenerator(name="person_seq", initialValue = 100_001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    Long id;

    String firstName;
    String lastName;

    @OneToOne
    Address address;

    String dateOfBirth;
    Integer score;

    public Person(String firstName, String lastName, String dateOfBirth, Integer score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.score = score;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", dateOfBirth=" + dateOfBirth +
                ", score=" + score +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getScore() {
        return score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
