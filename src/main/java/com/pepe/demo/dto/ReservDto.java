package com.pepe.demo.dto;

import javax.validation.constraints.NotBlank;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;

@Data
public class ReservDto {

    @NotNull
    private int Idx;
    
    @NotNull
    private int ReservationIdx;

    @NotNull
    private int SeatsNo;
    
    @NotNull
    private int ReservationYn;
    
    @NotBlank
    private String Id;
}
