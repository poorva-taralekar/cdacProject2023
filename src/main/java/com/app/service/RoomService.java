package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.RoomDTO;
import com.app.entities.Room;

public interface RoomService {

	public List<Room> getAllRoomDetails();
	
	Room addRoomDetails(Room rm);
	
	Room updateRoomDetails(Room rm);
	
	public Optional<Room> getRoom(Long id);
	
	String deleteRoomDetails(Long id);
	
	public List<RoomDTO> getAvailableRooms(String city);	
}