package com.pepe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepe.demo.dao.BusDao;
import com.pepe.demo.dao.PartialReservDao;
import com.pepe.demo.dto.BusDto;
import com.pepe.demo.dto.PartialReservDto;
import com.pepe.demo.dto.ReservDto;
import com.pepe.demo.dao.ReservDao;

@Service
public class ReservServiceImpl implements ReservService{

   @Autowired
   PartialReservDao partialreservDao;

   @Autowired
   BusDao busDao;
   
   @Override
   public int updateSeats(PartialReservDto partialreservDto) {
       int result = partialreservDao.updateSeats(partialreservDto);
       return result;
   }

    
   @Override
   public int insertReservation(PartialReservDto partialreservDto) {
       int reservation = partialreservDao.insertReservation(partialreservDto);
       return reservation;
   }

   @Override
   public List<PartialReservDto> reservedInfo(PartialReservDto partialreservDto) {
    List<PartialReservDto> reservedInfo = partialreservDao.reservedInfo(partialreservDto);
       return reservedInfo;
   }

   @Override
   public List<PartialReservDto> myreservedInfo(PartialReservDto partialreservDto) {
    List<PartialReservDto> myreservedInfo = partialreservDao.myreservedInfo(partialreservDto);
       return myreservedInfo;
   }

   @Override
    public int deleteInfo(PartialReservDto partialreservDto) {
        return partialreservDao.deleteInfo(partialreservDto);
    }

    @Override
    public int updateInfo(PartialReservDto partialreservDto) {
        return partialreservDao.updateInfo(partialreservDto);
    }

    // @Override
    // public int deleteInfo(int idx) {
    //     return partialreservDao.deleteInfo(idx);
    // }

    // @Override
    // public int updateInfo(int amount, int idx) {
    //     return partialreservDao.updateInfo(amount, idx);
    // }
}