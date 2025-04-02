package com.triptrop.adapter.adapter;

import com.triptrop.adapter.dto.HotelDto;
import org.springframework.stereotype.Component;


public interface HotelApiAdapter {
    HotelDto fetchHotelDetail(int hotelId,String arrivalDate, String departureDate);

}
