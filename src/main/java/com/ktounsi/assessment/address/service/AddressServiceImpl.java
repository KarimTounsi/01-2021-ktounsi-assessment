package com.ktounsi.assessment.address.service;

import com.ktounsi.assessment.address.entity.Address;
import com.ktounsi.assessment.address.repository.AddressRepository;
import com.ktounsi.assessment.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;


    @Override
    public Address getById(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isEmpty()) throw new ObjectNotFoundException("not.found.address");
        return optionalAddress.get();
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {

        Address addressDB = getById(address.getId());
        addressDB.setCity(address.getCity());
        addressDB.setHomeNumber(address.getHomeNumber());
        addressDB.setStreet(address.getStreet());
        addressDB.setPostCode(address.getPostCode());
        return addressRepository.save(addressDB);
    }

    @Override
    public void delete(Long id) {
        Address addressDB = getById(id);
        addressRepository.delete(addressDB);
    }
}
