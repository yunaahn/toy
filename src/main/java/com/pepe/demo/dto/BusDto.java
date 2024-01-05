package com.pepe.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;

@Data
public class BusDto {
    private int idx;

    
    private int BusNo;
    
    
    private int SeatsTotal;
    
    private int Booked;
    
    private int Remaining;
    
    @NotBlank
    private String Departure;
    
    @NotBlank
    private String Arrival;
    
    @NotEmpty
    private String BusDate;
}

