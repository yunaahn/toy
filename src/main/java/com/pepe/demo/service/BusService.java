package com.pepe.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.pepe.demo.dto.BusDto;

public interface BusService {
    int insertBus(BusDto busDto);
    List<BusDto> getBusList(String datepicker);
    List<BusDto> getBusListByDate(LocalDate selectedDate);
    List<BusDto> getRankByDate(LocalDate selectedDate);
}
