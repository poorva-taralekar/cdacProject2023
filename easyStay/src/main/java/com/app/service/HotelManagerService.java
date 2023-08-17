package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.HotelManager;

public interface HotelManagerService {
	
	public List<HotelManager> getAllHotelManagerDetails();
	
	HotelManager addHmDetails(HotelManager hm);
	
	HotelManager updateHmDetails(HotelManager hm);
	
	public Optional<HotelManager> getHotelManager(Long id);
	
	String deleteHmDetails(Long id);
	
}
