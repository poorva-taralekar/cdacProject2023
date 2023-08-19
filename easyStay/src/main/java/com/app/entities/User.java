package com.app.entities;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {
	@Column(length = 25)
	private String address;
	@Column(unique = true)
	private String email;
	@Column(length = 25)
	private String name;
	@Column(length = 25)
	private String city;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private ROLE role;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel myHotel;
    
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "us")
	private BookingTbl bk;
	
	public User() {
		super();
	}

	public User(String address, String email, String name, String city, String password, ROLE role, Hotel myHotel) {
		super();
		this.address = address;
		this.email = email;
		this.name = name;
		this.city = city;
		this.password = password;
		this.role = role;
		this.myHotel = myHotel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ROLE getRole() {
		return role;
	}

	public void setRole(ROLE role) {
		this.role = role;
	}

	public Hotel getMyHotel() {
		return myHotel;
	}

	public void setMyHotel(Hotel myHotel) {
		this.myHotel = myHotel;
	}

	@Override
	public String toString() {
		return "User [address=" + address + ", email=" + email + ", name=" + name + ", city=" + city + ", password="
				+ password + ", role=" + role + ", myHotel=" + myHotel + "]";
	}
}
