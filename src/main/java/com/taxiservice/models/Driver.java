package com.taxiservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Driver {
    private Long id;
    private String name;
    private String phoneNumber;
    private String carType;
    private int maxPassengers;
    private double averageRating;
}
