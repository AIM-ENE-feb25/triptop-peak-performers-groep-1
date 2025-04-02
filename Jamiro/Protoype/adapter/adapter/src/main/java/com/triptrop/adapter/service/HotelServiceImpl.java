package com.triptrop.adapter.service;

import com.triptrop.adapter.adapter.HotelApiAdapter;
import com.triptrop.adapter.dto.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelServicePort{
    private final HotelApiAdapter HOTELAPIADAPTER;

    @Autowired
    public HotelServiceImpl(HotelApiAdapter hotelapiadapter) {
        HOTELAPIADAPTER = hotelapiadapter;
    }

    @Override
    public HotelDto getHotelDetails(int hotelId) {
        HOTELAPIADAPTER.fetchHotelDetail(hotelId);
        return null;
    }
}
