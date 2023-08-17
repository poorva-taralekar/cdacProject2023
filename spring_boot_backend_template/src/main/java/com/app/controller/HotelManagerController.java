package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entities.HotelManager;
import com.app.service.HotelManagerService;

@RestController
@RequestMapping("/hotelManager")
public class HotelManagerController {
	@Autowired
	private HotelManagerService hms;
	
	public HotelManagerController()
	{
		System.out.println("In ctor of "+getClass());
	}
	
	@GetMapping("/")
	public List<HotelManager> listAllHotelManagers(){
		return hms.getAllHotelManagerDetails();
	}
	
	@PostMapping
	public HotelManager addNewHm(@RequestBody HotelManager hm)
	{
		return hms.addHmDetails(hm);
		
	}
	
//	@GetMapping("/{empId}")
//	//@pathVariable => method arg level annotation, to bind incoming uri variable
//	public Optional<HotelManager> upd1(@PathVariable Long hmId){
//		System.out.println("In get Emp Details: "+hmId);
//		return hms.updateHmDetails(hmId);
//				//.orElseThrow(() -> new RessourceNotFoundException("Invalid Emp Id"));
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
