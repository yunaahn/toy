package com.pepe.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pepe.demo.dto.BusDto;
import com.pepe.demo.service.BusService;

@Controller
public class BusController {

    @Autowired
    BusService busService;
    
    @GetMapping("/bus/register")
    public String register(){
        return "bus/register";
    }

   
    @PostMapping("/bus/register")
    public String registerProcess(
        @Valid BusDto busDto,
        BindingResult bindingResult,
        Model model
    ){  
        if (bindingResult.hasErrors()) {
            model.addAttribute("busDto", busDto);
            return "/bus/register";
          }
        int result = busService.insertBus(busDto);
        return "bus/register";
    }


    @GetMapping("/reservation/list")
    public String listForm(Model model) {
        return "reservation/list";
    }

  
    @ResponseBody
    @PostMapping("/reservation/list")
    public ResponseEntity<List<BusDto>> listSubmit(@RequestParam("datepicker") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datepicker) {
        List<BusDto> busList = busService.getBusListByDate(datepicker);
        return ResponseEntity.ok().body(busList);
    }

    @ResponseBody
    @PostMapping("/reservation/rank")
    public ResponseEntity<List<BusDto>> getRank(@RequestParam("datepicker") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datepicker) {
        List<BusDto> busList = busService.getRankByDate(datepicker);
        return ResponseEntity.ok().body(busList);
    }
        

    }

    

