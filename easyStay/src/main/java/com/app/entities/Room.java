package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class Room extends BaseEntity {

	
	@Column(length = 10)
	private int status;
	
	@Enumerated(EnumType.STRING)
	private RoomType type;
//	id : int ----- PK
//	hotel_id  : int ---FK
//	booking_id : int ---- FK
//	room : varchar
//	status:int (0,1)
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel myHotel;
}
