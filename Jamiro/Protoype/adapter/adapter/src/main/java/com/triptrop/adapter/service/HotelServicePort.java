package com.triptrop.adapter.service;

import com.triptrop.adapter.dto.HotelDto;

public interface HotelServicePort {
    HotelDto getHotelDetails(int hotelId);
}
