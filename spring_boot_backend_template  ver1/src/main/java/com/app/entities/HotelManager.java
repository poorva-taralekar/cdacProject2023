package com.app.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table
public class HotelManager extends BaseEntity{
	
	@Column(length = 30)
	private String name;
	@Column(length = 50)
	private String address;
	@Column(length = 20)
	private String city;
}
