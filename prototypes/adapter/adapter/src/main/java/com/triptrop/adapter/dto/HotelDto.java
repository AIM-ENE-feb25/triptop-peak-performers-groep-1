package com.triptrop.adapter.dto;

public class HotelDto {
    private int hotelId;
    private String Naam;
    private String Beschrijving;
    private String Locatie;

    public void setHotelName(String hotelName) {
        Naam = hotelName;
    }
    public String getNaam() {
        return Naam;
    }

    public void setLocatie(String locatie) {
        Locatie = locatie;
    }
    public String getLocatie() {
        return Locatie;
    }
}
