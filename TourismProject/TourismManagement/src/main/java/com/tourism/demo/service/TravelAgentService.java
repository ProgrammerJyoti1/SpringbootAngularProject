package com.tourism.demo.service;

import java.util.List;

import com.tourism.demo.entity.TravelAgent;


public interface TravelAgentService {
	public  TravelAgent addTravelAgent( TravelAgent tr);
	public List<TravelAgent> getAllTravelAgent();		
	public  TravelAgent getTravelAgentById(long TravelAgent_id);	
	public  TravelAgent updateTravelAgent(TravelAgent tr);
	public String deleteTravelAgent(long TravelAgent_id);
}
