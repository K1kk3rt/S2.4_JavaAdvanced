package nl.inholland.service;

import nl.inholland.model.Address;
import nl.inholland.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

}
