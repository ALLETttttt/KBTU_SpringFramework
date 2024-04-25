package kz.project.addressservice.service;

import kz.project.addressservice.model.Address;

public interface AddressService {
    Address getAddressByPostalCode(String postalCode);
}
