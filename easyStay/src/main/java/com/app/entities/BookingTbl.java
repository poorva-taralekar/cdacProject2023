package com.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BookingTbl extends BaseEntity {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkIn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkOut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookinDate;
	@NotNull
	private int prize;

	@OneToOne
	@JoinColumn(name = "room_id")	
	private Room rm;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User us;
	public BookingTbl() {
		super();
	}

	public BookingTbl(LocalDate checkIn, LocalDate checkOut, LocalDate bookinDate, @NotNull int prize) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.bookinDate = bookinDate;
		this.prize = prize;
	}
	
	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public LocalDate getBookinDate() {
		return bookinDate;
	}

	public void setBookinDate(LocalDate bookinDate) {
		this.bookinDate = bookinDate;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "BookingTbl [checkIn=" + checkIn + ", checkOut=" + checkOut + ", bookinDate=" + bookinDate + ", prize="
				+ prize + "]";
	}

}
