package kz.project.orderservice.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String postalCode;
    private String state;
    private String city;
}
