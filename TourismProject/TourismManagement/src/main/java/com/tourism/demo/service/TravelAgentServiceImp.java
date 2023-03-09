package com.tourism.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.demo.dao.TravelAgentRepository;
import com.tourism.demo.entity.TravelAgent;
@Service
public class TravelAgentServiceImp implements TravelAgentService{
	@Autowired
    TravelAgentRepository dao;
	
	@Override
	public TravelAgent addTravelAgent(TravelAgent tr) {
		System.out.println("TravelAgent added Succesfully "+tr);
		tr.setTravel_agent_name(tr.getTravel_agent_name());
		tr.setTravel_agent_mobile(tr.getTravel_agent_mobile());
		tr.setTravel_agent_email(tr.getTravel_agent_email());
		tr.setTravel_agent_password(tr.getTravel_agent_password());
		tr.setStreet(tr.getStreet());
		tr.setDistrict(tr.getDistrict());
		tr.setZip(tr.getZip());
		tr.setState(tr.getState());
		return dao.save(tr);
	}

	@Override
	public List<TravelAgent> getAllTravelAgent() {
		return dao.findAll();
	}

	@Override
	public TravelAgent getTravelAgentById(long TravelAgent_id) {
		return this.dao.findById(TravelAgent_id).orElse(null);
	}

	@Override
	public TravelAgent updateTravelAgent(TravelAgent tr) {
		TravelAgent existsAgent = dao.findById(tr.getTravelAgent_id()).orElse(null);
		existsAgent.setTravel_agent_name(tr.getTravel_agent_name());
		existsAgent.setTravel_agent_mobile(tr.getTravel_agent_mobile());
		existsAgent.setTravel_agent_email(tr.getTravel_agent_email());
		existsAgent.setTravel_agent_password(tr.getTravel_agent_password());
		existsAgent.setStreet(tr.getStreet());
		existsAgent.setDistrict(tr.getDistrict());
		existsAgent.setZip(tr.getZip());
		existsAgent.setState(tr.getState());
		return dao.save(existsAgent);
	}

	@Override
	public String deleteTravelAgent(long TravelAgent_id) {
		TravelAgent existsID = dao.findById(TravelAgent_id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(TravelAgent_id);
		return "TravelAgent deleted!!";
		}
		else
		{
		return "TravelAgent does not exist!!";
		}
	}

	

	



}
