package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@GetMapping("/{hmId}")
	//@pathVariable => method arg level annotation, to bind incoming uri variable
	public Optional<HotelManager> upd1(@PathVariable Long hmId){
		System.out.println("In get Hm Details: "+hmId);
		return hms.getHotelManager(hmId);
				//.orElseThrow(() -> new RessourceNotFoundException("Invalid Emp Id"));
	}
	
	@PutMapping
	public HotelManager updateEmpDetails(@RequestBody HotelManager hm)
	{
		System.out.println("In update emp"+hm.getId());
		return hms.updateHmDetails(hm);	
	}
	
	@DeleteMapping("/{hmId}") // 
	public String deleteHotelManager(@PathVariable Long hmId) {
		System.out.println("in Delete Emp "+hmId);
		hms.deleteHmDetails(hmId);
		return "Removed !";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
