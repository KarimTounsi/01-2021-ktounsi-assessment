package com.ktounsi.assessment.address.service;

import com.ktounsi.assessment.address.entity.Address;

public interface AddressService {

    Address getById(Long id);

    Address saveAddress(Address address);

    Address update(Address address);

   void delete(Long id);

}
