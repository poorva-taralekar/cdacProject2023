package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel extends BaseEntity {
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 50)
	private String address;
	
	@Column(length = 20)
	private String city;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User users;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "myHotel", orphanRemoval = true)
	private List<Room> room = new ArrayList<>();
}