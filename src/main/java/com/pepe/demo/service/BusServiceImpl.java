package com.pepe.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepe.demo.dao.BusDao;
import com.pepe.demo.dto.BusDto;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    BusDao busDao;

    @Override
    public int insertBus(BusDto busDto) {
        int result = busDao.insertBus(busDto);
        return result;
    }

    @Override
    public List<BusDto> getBusList(String datepicker) {
        // datepicker를 적절한 형식으로 변환 (예: "yyyy-MM-dd")
        LocalDate selectedDate = LocalDate.parse(datepicker, DateTimeFormatter.ISO_DATE);

        // 변환된 날짜를 이용하여 데이터베이스에서 버스 목록을 검색
        List<BusDto> busList = busDao.getBusListByDate(selectedDate.toString());
        return busList;
    }

    @Override
    public List<BusDto> getBusListByDate(LocalDate selectedDate) {
        String formattedDate = selectedDate.format(DateTimeFormatter.ISO_DATE);
        List<BusDto> busList = busDao.getBusListByDate(formattedDate);
        return busList;
    }

  
    @Override
    public List<BusDto> getRankByDate(LocalDate selectedDate) {
        String formattedDate = selectedDate.format(DateTimeFormatter.ISO_DATE);
        List<BusDto> busList = busDao.getRankByDate(formattedDate);
        return busList;
    }

}
