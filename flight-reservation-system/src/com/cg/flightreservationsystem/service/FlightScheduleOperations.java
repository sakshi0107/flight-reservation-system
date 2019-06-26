package com.cg.flightreservationsystem.service;

import com.cg.flightreservationsystem.dto.ScheduleDTO;
import com.cg.flightreservationsystem.exception.EmptyListException;
import com.cg.flightreservationsystem.exception.InvalidDateException;
import com.cg.flightreservationsystem.exception.InvalidPriceException;
import com.cg.flightreservationsystem.exception.InvalidScheduleIdException;
import com.cg.flightreservationsystem.exception.InvalidTimeException;

public interface FlightScheduleOperations 
{
	public boolean add(ScheduleDTO schedule) throws InvalidScheduleIdException, InvalidDateException, InvalidPriceException, InvalidTimeException, EmptyListException;
	public boolean delete(ScheduleDTO schedule) throws InvalidScheduleIdException, EmptyListException;
}
