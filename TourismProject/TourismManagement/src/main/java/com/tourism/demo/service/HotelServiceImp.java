package com.tourism.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.demo.dao.HotelRepository;
import com.tourism.demo.entity.Hotel;
@Service
public class HotelServiceImp implements HotelService{
	@Autowired
	HotelRepository dao;
	
	@Override
	public Hotel addHotel(Hotel h) {
		System.out.println("Hotel has added Succesfully" +h);				
		h.setHotel_name(h.getHotel_name());
		h.setStreet(h.getStreet());
		h.setDistrict(h.getDistrict());
		h.setState(h.getState());
		h.setZip(h.getZip());
		h.setHotel_desc(h.getHotel_desc());
		h.setHotel_fair(h.getHotel_fair());
		return dao.save(h);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return dao.findAll();
	}

	@Override
	public Hotel getHotelById(long Hotel_id) {	
		return this.dao.findById(Hotel_id).orElse(null);
	}

	@Override
	public Hotel updateHotel(Hotel h) {
	  Hotel exitingHotel=dao.findById(h.getHotel_id()).orElse(null);
		exitingHotel.setHotel_name(h.getHotel_name());
		exitingHotel.setStreet(h.getStreet());
		exitingHotel.setDistrict(h.getDistrict());
		exitingHotel.setState(h.getState());
		exitingHotel.setZip(h.getZip());
		exitingHotel.setHotel_desc(h.getHotel_desc());
		exitingHotel.setHotel_fair(h.getHotel_fair());
		return dao.save(exitingHotel);
	}
	
	@Override
	public String deleteHotel(long Hotel_id) {
		Hotel existsID=dao.findById(Hotel_id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(Hotel_id);
		return "Hotel has deleted!!";
		}
		else
		{
		return "Hotel does not exist!!";
		}
		
	}

}
