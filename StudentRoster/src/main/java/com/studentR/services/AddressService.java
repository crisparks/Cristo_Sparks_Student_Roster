package com.studentR.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studentR.models.Address;
import com.studentR.repositories.AddressRepository;


@Service
public class AddressService {
	// adding the Address repository as a dependency
	private final AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	// create a address
	public Address createAddress(Address address) {
		return addressRepository.save(address);
	}

	// find Address by id
	public Address findAddress(Long id) {
		Optional<Address> findLic = addressRepository.findById(id);
		if (findLic.isPresent()) {
			return findLic.get();
		} else {
			return null;
		}
	}
}