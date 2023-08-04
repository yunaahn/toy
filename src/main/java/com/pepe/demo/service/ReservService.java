package com.pepe.demo.service;

import java.util.List;

import com.pepe.demo.dto.BusDto;
import com.pepe.demo.dto.PartialReservDto;
import com.pepe.demo.dto.ReservDto;

public interface ReservService {
    //int updateSeats(BusDto busDto);
    int updateSeats(PartialReservDto partialreservDto);
    int insertReservation(PartialReservDto partialreservDto);
    // int deleteInfo(int idx);
    // int updateInfo(int amount, int idx);
    int deleteInfo(PartialReservDto partialreservDto);
    int updateInfo(PartialReservDto partialreservDto);
    List<PartialReservDto> reservedInfo(PartialReservDto partialreservDto);
    List<PartialReservDto> myreservedInfo(PartialReservDto partialreservDto);
}