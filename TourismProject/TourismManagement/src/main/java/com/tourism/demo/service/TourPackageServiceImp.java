package com.tourism.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.demo.dao.TourPackageRepository;
import com.tourism.demo.entity.TourPackage;
@Service
public class TourPackageServiceImp implements TourPackageService {

	@Autowired
	TourPackageRepository dao;

	@Override
	public TourPackage addTourPackage(@Valid TourPackage pa) {
		pa.setPackage_name(pa.getPackage_name());
		pa.setPackage_amount(pa.getPackage_amount());
		pa.setPackage_desc(pa.getPackage_desc());
		return dao.save(pa);
	}

	@Override
	public List<TourPackage> getAllPackage() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public TourPackage getPackageById(long Package_id) {
		return this.dao.findById(Package_id).orElse(null);
	}

	@Override
	public TourPackage updateTourPackage(TourPackage pa) {
		TourPackage existingTour=dao.findById(pa.getPackage_id()).orElse(null);
		
		existingTour.setPackage_name(pa.getPackage_name());
		existingTour.setPackage_amount(pa.getPackage_amount());
		existingTour.setPackage_desc(pa.getPackage_desc());
		return dao.save(existingTour);
	}

	@Override
	public String deleteTourPackage(long Package_id) {
		TourPackage existsTourID=dao.findById(Package_id).orElse(null);
		if(existsTourID!=null)
		{
		dao.deleteById(Package_id);
		return "Package deleted!!";
		}
		else
		{
		return "Package does not exist!!";
		}
	}
}
