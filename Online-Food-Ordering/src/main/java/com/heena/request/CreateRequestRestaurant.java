package com.heena.request;

import com.heena.model.Address;
import com.heena.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRequestRestaurant  {

    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private String OpeningHours;
    private List<String> images;


}
