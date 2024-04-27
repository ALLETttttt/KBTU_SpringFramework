package kz.project.addressservice.service.Impl;

import kz.project.addressservice.model.Address;
import kz.project.addressservice.repository.AddressRepository;
import kz.project.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddressByPostalCode(String postalCode) {
        return addressRepository.findByPostalCode(postalCode)
                .orElseThrow(() -> new RuntimeException(
                        "Address Not Found: " + postalCode
                ));
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
