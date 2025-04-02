package com.triptrop.adapter.service;

import com.triptrop.adapter.dto.HotelDto;

public interface HotelServicePort {
    HotelDto retrieveHotelDetails(int hotelId, String arrivalDate, String departureDate);
}
