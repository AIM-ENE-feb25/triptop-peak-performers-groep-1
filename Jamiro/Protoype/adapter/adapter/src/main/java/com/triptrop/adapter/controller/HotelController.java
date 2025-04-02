package com.triptrop.adapter.controller;

import com.triptrop.adapter.service.HotelServiceImpl;
import com.triptrop.adapter.service.HotelServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HotelController {
    private final HotelServiceImpl HOTELSERVICEIMPL;

    @Autowired
    public HotelController(HotelServiceImpl hotelserviceimpl) {
        HOTELSERVICEIMPL = hotelserviceimpl;
    }


    @GetMapping("/getHotelDetails")
    public ResponseEntity<String> getHotelDetails(@RequestParam int hotelId) {
        HOTELSERVICEIMPL.getHotelDetails(hotelId);
        return ResponseEntity.ok("Hotel is opgehaald");
    }
}
