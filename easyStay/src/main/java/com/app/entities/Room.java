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

	public Room() {
		super();
	}

	public Room(int status, RoomType type, Hotel myHotel) {
		super();
		this.status = status;
		this.type = type;
		this.myHotel = myHotel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Hotel getMyHotel() {
		return myHotel;
	}

	public void setMyHotel(Hotel myHotel) {
		this.myHotel = myHotel;
	}

	@Override
	public String toString() {
		return "Room [status=" + status + ", type=" + type + ", myHotel=" + myHotel + "]";
	}
}
