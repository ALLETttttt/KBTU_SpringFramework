package kz.project.addressservice.service;

import kz.project.addressservice.model.Address;

import java.util.List;

public interface AddressService {
    Address getAddressByPostalCode(String postalCode);

    List<Address> getAllAddresses();
}
