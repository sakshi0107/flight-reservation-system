package com.cg.flightreservationsystem.service;

import com.cg.flightreservationsystem.dto.RouteDTO;
import com.cg.flightreservationsystem.exception.EmptyListException;
import com.cg.flightreservationsystem.exception.InvalidCapacityInputException;
import com.cg.flightreservationsystem.exception.InvalidCityInputException;
import com.cg.flightreservationsystem.exception.InvalidFlightIdInputException;
import com.cg.flightreservationsystem.exception.InvalidRouteIdException;

public interface FlightRouteOperations 
{
	public boolean add(RouteDTO route) throws InvalidRouteIdException, InvalidCityInputException, EmptyListException;
	public boolean delete(RouteDTO route) throws InvalidRouteIdException, EmptyListException;
}
