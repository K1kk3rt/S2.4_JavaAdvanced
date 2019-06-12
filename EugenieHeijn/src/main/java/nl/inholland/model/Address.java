package nl.inholland.model;

import javax.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @SequenceGenerator(name="address_seq", initialValue = 100_001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    Long id;

    String streetName;
    String houseNumber;
    String zipCode;
    String city;

    public Address(Long id,String streetName, String houseNumber, String zipCode, String city) {
        this.id = id;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address() {
    }

    public long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
