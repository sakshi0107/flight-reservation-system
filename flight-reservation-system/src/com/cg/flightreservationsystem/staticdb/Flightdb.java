package com.cg.flightreservationsystem.staticdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cg.flightreservationsystem.dto.FlightDTO;
import com.cg.flightreservationsystem.exception.InvalidFlightIdInputException;

public class Flightdb {
	public static List<FlightDTO> flightList = new ArrayList<FlightDTO>();
	static {
		Flightdb.flightList.add(new FlightDTO("fa-101", "300"));
		Flightdb.flightList.add(new FlightDTO("fa-102", "200"));
		Flightdb.flightList.add(new FlightDTO("fa-103", "150"));
		Flightdb.flightList.add(new FlightDTO("fa-104", "300"));
		Flightdb.flightList.add(new FlightDTO("fa-105", "240"));
		Flightdb.flightList.add(new FlightDTO("fa-106", "350"));
		Flightdb.flightList.add(new FlightDTO("fa-107", "400"));	
	}
	
	public boolean add(FlightDTO flight) throws InvalidFlightIdInputException 
	{
			return Flightdb.flightList.add(flight);	
	}
	
	public boolean delete(FlightDTO flight) throws InvalidFlightIdInputException
	{	
			return Flightdb.flightList.remove(flight);
	}
	public static List<FlightDTO> getflightList() {
		return flightList;
	}
	
	
	
	
}
	
	
	

