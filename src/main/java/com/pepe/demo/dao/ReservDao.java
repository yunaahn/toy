package com.pepe.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pepe.demo.dto.PartialReservDto;
import com.pepe.demo.dto.ReservDto;



@Mapper
public interface ReservDao {
    int insertReservation(ReservDto reservDto);
    List<PartialReservDto> reservedInfo(PartialReservDto partialreservDto);
}
