package com.cg.flightreservationsystem.service;

import java.util.List;

import com.cg.flightreservationsystem.dto.FlightDTO;
import com.cg.flightreservationsystem.exception.EmptyListException;
import com.cg.flightreservationsystem.exception.InvalidCapacityInputException;
import com.cg.flightreservationsystem.exception.InvalidFlightIdInputException;

//interface declaration
public interface FlightDetailsOperations 
{
	public boolean add(FlightDTO flight) throws InvalidFlightIdInputException, InvalidCapacityInputException,EmptyListException;
	public boolean delete(FlightDTO flight) throws InvalidFlightIdInputException, EmptyListException;
}
