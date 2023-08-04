package com.pepe.demo.dto;

import javax.validation.constraints.NotBlank;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;

@Data
public class PartialReservDto {

    private int ReservationIdx;
    private int Amount;
    private String Id;
    private int Idx;
    private String BusDate;
    private int BusNo;
    private String Departure;
    private String Arrival;
}
