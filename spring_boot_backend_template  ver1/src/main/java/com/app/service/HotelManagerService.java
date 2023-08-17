package com.app.service;

import java.util.List;

import com.app.entities.HotelManager;

public interface HotelManagerService {
	
	public List<HotelManager> getAllHotelManagerDetails();
	
	HotelManager addHmDetails(HotelManager hm);
	
	HotelManager updateHmDetails(HotelManager hm);
	
	
}
