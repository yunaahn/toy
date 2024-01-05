package com.pepe.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pepe.demo.dto.BusDto;

@Mapper
public interface BusDao {
    int insertBus(BusDto busDto);
    List<BusDto> getBusList();
    List<BusDto> getBusListByDate(String selectedDate);
    List<BusDto> getRankByDate(String selectedDate);
    int updateRemaining(BusDto busDto);
    int updateBooked(BusDto busDto);
}
