package com.app.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.HotelDao;
import com.app.dao.UserDao;
import com.app.dto.HotelResponseDTO;
import com.app.entities.Hotel;
import com.app.entities.ROLE;
import com.app.entities.User;

@Service
@Transactional
public class HotelServiceImpli implements HotelService {

	@Autowired
	private HotelDao h;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Hotel> getAllHotelDetails() {
		
		return h.findAll();
	}

	@Override
	public Hotel addHotelDetails(Hotel hm) {
		
		return h.save(hm);
	}

	@Override
	public Hotel updateHotelDetails(Hotel detachHm) {
		h.findById(detachHm.getId()).orElseThrow();
		return h.save(detachHm);
	}

	@Override
	public Optional<Hotel> getHotel(Long id) {
		
		return h.findById(id);
	}

	@Override
	public String deleteHotelDetails(Long id) {
		//d.findById(id).orElseThrow();
		h.deleteById(id);
		return "Successfully deleted!!";
	}
	
	@Override
	public Hotel updateHotelByOwner(Long ownerId, Long hotelId, Hotel updatedHotel) throws Exception {
		 User owner = userDao.findById(ownerId)
	                .orElseThrow(() -> new EntityNotFoundException("Owner not found"));

	        Hotel hotelToUpdate = h.findById(hotelId)
	                .orElseThrow(() -> new EntityNotFoundException("Hotel not found"));

	        // Ensure the owner owns the hotel
	        if (!owner.getRole().equals(ROLE.OWNER) || !hotelToUpdate.getUsers().equals(owner)) {
	            throw new Exception("Owner is not authorized to update this hotel");
	        }

	        // Update hotel details
	        hotelToUpdate.setName(updatedHotel.getName());
	        hotelToUpdate.setAddress(updatedHotel.getAddress());
	        hotelToUpdate.setCity(updatedHotel.getCity());

	        return h.save(hotelToUpdate);	
	}

	@Override
	public List<HotelResponseDTO> getMyHotels(Long ownerId) {
		User owner = userDao.findById(ownerId)
				.orElseThrow(() -> new EntityNotFoundException("Owner not found"));
		
	
		//Optional<Hotel> list = h.findById(owner.getId());
		List<Hotel> hotels = owner.getHotels();
		return hotels.stream()
	            .map(this::convertToDTO)
	            .collect(Collectors.toList());
	}

	private HotelResponseDTO convertToDTO(Hotel hotel) {
		HotelResponseDTO dto = new HotelResponseDTO();
	    dto.setName(hotel.getName());
	    dto.setAddress(hotel.getAddress());
	    dto.setCity(hotel.getCity());
	    dto.setUserId(hotel.getUsers().getId());
	    // Set other fields

	    return dto;
	};

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
