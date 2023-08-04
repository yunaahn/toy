package com.pepe.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pepe.demo.dto.PartialReservDto;
import com.pepe.demo.dto.ReservDto;



@Mapper
public interface PartialReservDao {
    List<PartialReservDto> reservedInfo(PartialReservDto partialreservDto);
    List<PartialReservDto> myreservedInfo(PartialReservDto partialreservDto);
    int updateSeats(PartialReservDto partialreservDto);
    int insertReservation(PartialReservDto partialreservDto);
    // int deleteInfo(int idx);
    // int updateInfo(int amount, int idx);
    int deleteInfo(PartialReservDto partialreservDto);
    int updateInfo(PartialReservDto partialreservDto);
}
