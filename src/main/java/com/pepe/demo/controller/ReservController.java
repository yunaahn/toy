package com.pepe.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pepe.demo.dto.BusDto;
import com.pepe.demo.dto.PartialReservDto;
import com.pepe.demo.dto.ReservDto;
import com.pepe.demo.service.ReservService;


@Controller
public class ReservController {
    
    @Autowired
    ReservService reservService;
    
    @GetMapping("/reservation/reservation")
    public String reservation(){
        return "/reservation/reservation";
    }



//getmapping : post(입력)받는 경우 제외

    //@ResponseBody
    @GetMapping("/reservation/details")
    public List<PartialReservDto> details(PartialReservDto partialReservDto){
        //param idx 값을 파라미터로 받아서 넘긴다
        //넘긴 idx가 dto에 담기도록 해준다

        //dto를 param 객체에 생성하여 담음
        //해당 객체에 Idx 라는 dto 값을 파람 idx 값으로 세팅해서 설정해줌
        //PartialReservDto param = new PartialReservDto();
       
       // param.setIdx(idx);

        //서비스 매소드인 reservedInfo 에 생성한 param을 넣어준다 
        List<PartialReservDto> reservedList = reservService.reservedInfo(partialReservDto);
        //System.out.println("Received idx: " + idx);
        System.out.println("reservedList: " + reservedList);
        return reservedList;
    }

    //리스트 페이지 get - 그냥 페이지 불러오는 부분 /post - 데이터에 따라 조회하는 부분

    @GetMapping("/reservation/mylist")
    public String mylist(Model model) {
        return "reservation/mylist";
    }

//페이지에서 데이터를 받아온 걸 post로 보낼 때 
//dto 에 해당하는 데이터값은 setid로 담아서 서비스에서 조회할 수 있다
    @ResponseBody
    @PostMapping("/reservation/mylist")
    public List<PartialReservDto> mydetails(@RequestParam("id") String id) {
        PartialReservDto partialReservDto = new PartialReservDto();
        partialReservDto.setId(id);
        List<PartialReservDto> busList = reservService.myreservedInfo(partialReservDto);
        return busList;
    }
    
        

    @PostMapping("/reservation/update")
    public String reservationProcess(
        @Valid PartialReservDto partialreservDto,
        BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return "redirect:/?msg=0";
        }
      
        int result = reservService.updateSeats(partialreservDto);

        if (result > 0 ) {
            return "redirect:/?msg=1";
        } else {
            return "redirect:/?msg=0";
        }
    }

    @PostMapping("/reservation/insert")
    public String reservationInsert(
        @Valid PartialReservDto partialreservDto,
        BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return "redirect:/?msg=0";
        }
      
        int reservation = reservService.insertReservation(partialreservDto);

        if (reservation > 0) {
            return "redirect:/?msg=1";
        } else {
            return "redirect:/?msg=0";
        }
    }

   //dtork 아닌 RequestParam으로 값을 받아서 서비스에 보낼 수 있따

    @PostMapping("/reservation/delete")
        public String delete(@RequestParam("idx") int idx) {
            PartialReservDto partialReservDto = new PartialReservDto();
            partialReservDto.setIdx(idx);



            int result = reservService.deleteInfo(partialReservDto);
            if (result > 0) {
                return "redirect:/";
            }
            return "redirect:/";
        }

        @PostMapping("/reservation/deleteupdate")
        public String deleteupdate(@RequestParam("idx") int idx
        , @RequestParam("amount") int amount) {
            PartialReservDto partialReservDto = new PartialReservDto();
            partialReservDto.setIdx(idx);
            partialReservDto.setAmount(amount);



            int result = reservService.updateInfo(partialReservDto);
            if (result > 0) {
                return "redirect:/";
            }
            return "redirect:/";
        }
}
