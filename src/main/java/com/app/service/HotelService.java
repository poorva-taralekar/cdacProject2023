package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.HotelResponseDTO;
import com.app.entities.Hotel;

public interface HotelService {
	public List<Hotel> getAllHotelDetails();
	
	Hotel addHotelDetails(Hotel hm);
	
	Hotel updateHotelDetails(Hotel hm);
	
	public Optional<Hotel> getHotel(Long id);
	
	String deleteHotelDetails(Long id);
	
    public Hotel updateHotelByOwner(Long ownerId, Long hotelId, Hotel updatedHotel) throws Exception;
	
	public List<HotelResponseDTO> getMyHotels(Long ownerId);
	
	
}
