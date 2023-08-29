package com.app.entities;

import java.util.ArrayList;
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users", orphanRemoval = true)
	private List<Hotel> hotels = new ArrayList<>();
    
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "us")
	private BookingTbl bk;
}
