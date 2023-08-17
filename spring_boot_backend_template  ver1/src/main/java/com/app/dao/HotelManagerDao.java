package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.HotelManager;

public interface HotelManagerDao extends JpaRepository<HotelManager, Long> {

}
