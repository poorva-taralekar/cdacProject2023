package com.app.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.HotelManagerDao;
import com.app.entities.HotelManager;

@Service
@Transactional
public class HotelManagerServiceImpli implements HotelManagerService {

	@Autowired
	private HotelManagerDao d;
	
	@Override
	public List<HotelManager> getAllHotelManagerDetails() {
		
		return d.findAll();
	}

	@Override
	public HotelManager addHmDetails(HotelManager hm) {
		
		return d.save(hm);
	}

	@Override
	public HotelManager updateHmDetails(HotelManager detachHm) {
		d.findById(detachHm.getId()).orElseThrow();
		return d.save(detachHm);
	}
			
}
