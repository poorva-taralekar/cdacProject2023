package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Hotel extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 50)
	private String address;
	@Column(length = 20)
	private String city;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "myHotel", orphanRemoval = true)
	private List<User> users = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "myHotel", orphanRemoval = true)
	private List<User> room = new ArrayList<>();

	public Hotel() {
		super();
	}

	public Hotel(String name, String address, String city, List<User> users, List<User> room) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.users = users;
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getRoom() {
		return room;
	}

	public void setRoom(List<User> room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", address=" + address + ", city=" + city + ", users=" + users + ", room=" + room
				+ "]";
	}

}
