package com.tourism.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.demo.dao.BookingRepository;
import com.tourism.demo.entity.Booking;
@Service
public class BookingServiceImp  implements BookingService{


	@Autowired
	BookingRepository dao;

	@Override
	public List<Booking> getAllBooking() {

		return dao.findAll();
	}
	@Override
	public Booking getBookingById(long Booking_id) {
		// TODO Auto-generated method stub
		return this.dao.findById(Booking_id).orElse(null);
	}

	@Override
	public Booking updateBooking(Booking b) {
		Booking existingBk = dao.findById(b.getBooking_id()).orElse(null);
		existingBk.setRoomType(b.getRoomType());
		existingBk.setDay(b.getDay());
		existingBk.setPassengerCount(b.getPassengerCount());
		existingBk.setUserjoin(b.getUserjoin());
		return dao.save(existingBk);
	}

	@Override
	public String deleteBooking(long Booking_id) {
		Booking existsID=dao.findById(Booking_id).orElse(null);
		
		if(existsID!=null)
		{
		dao.deleteById(Booking_id);
		return "Booking deleted!!";
		}
		else
		{
		return "Booking does not exist!!";
		}
		
	}


	

}
