package com.noel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

    private Status status;

    private String owner;

    private String model;

    private String brand;

    @JsonProperty("license_number")
    private String licensePlateNumber;

    private Date associatedDate;
}
