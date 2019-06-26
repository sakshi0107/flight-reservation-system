package com.cg.flightreservationsystem.service.impl;

import java.util.List;

import com.cg.flightreservationsystem.dto.ScheduleDTO;
import com.cg.flightreservationsystem.exception.EmptyListException;
import com.cg.flightreservationsystem.exception.InvalidDateException;

import com.cg.flightreservationsystem.exception.InvalidPriceException;
import com.cg.flightreservationsystem.exception.InvalidScheduleIdException;
import com.cg.flightreservationsystem.exception.InvalidTimeException;

import com.cg.flightreservationsystem.service.FlightScheduleOperations;

import com.cg.flightreservationsystem.staticdb.Scheduledb;
import com.cg.flightreservationsystem.utility.Validation;

public class FlightScheduleOperationImpl implements FlightScheduleOperations {
	
	Validation validation = new Validation();
	Scheduledb scheduleDetails = new Scheduledb();
	
	public boolean add(ScheduleDTO schedule) throws  InvalidDateException, InvalidTimeException,InvalidPriceException, InvalidScheduleIdException, EmptyListException{
		String scheduleId = schedule.getScheduleId();
		String arrivalTime = schedule.getArrivalTime();
		String departureTime = schedule.getDepartureTime();
		String arrivalDate = schedule.getArrivalDate();
		String departureDate = schedule.getDepartureDate();
		String schedulePrice = schedule.getPrice();
		
		scheduleIdValidation(scheduleId);
		arrivalTimeValidation(arrivalTime);
		departureTimeValidation(departureTime);
		arrivalDateValidation(arrivalDate);
		departureDateValidation(departureDate);
		schedulePriceValidation(schedulePrice);
		
		boolean flag = false;
		List<ScheduleDTO> scheduleList = Scheduledb.getscheduleList();
		if(scheduleList == null || scheduleList.isEmpty()) {
			throw new EmptyListException("Flight List is empty");
		}
		else
		{
			for(ScheduleDTO scheduleDTO: scheduleList)
			{
				if(scheduleDTO.getScheduleId().equals(scheduleId)) {
					throw new InvalidScheduleIdException("id already exists, enter Another id");
				}
					else {
					scheduleDTO.setArrivalDate(arrivalDate);
					scheduleDTO.setDepartureDate(departureDate);
					scheduleDTO.setDepartureTime(departureTime);
					scheduleDTO.setArrivalTime(arrivalTime);
					schedule.setPrice(schedulePrice);
					flag = true;
					break;
				}
			}
		
			return scheduleDetails.add(schedule);
	}	
	}
	
	
	public boolean delete(ScheduleDTO schedule) throws InvalidScheduleIdException, EmptyListException{
		
		String scheduleId = schedule.getScheduleId();
		scheduleIdValidation(scheduleId);
		boolean flag = false;
		List<ScheduleDTO> scheduleList = Scheduledb.getscheduleList();
		if(scheduleList == null || scheduleList.isEmpty()) {
			throw new EmptyListException("Schedule List is empty");
		}
		else
		{
			for(ScheduleDTO scheduleDTO: scheduleList)
			{
				if(!(scheduleDTO.getScheduleId().equals(scheduleId))) {
					throw new InvalidScheduleIdException("id already exists, enter Another id");
				}
					else {
					flag = true;
					break;
				}
			}
		
			return scheduleDetails.delete(schedule);
	}	
	}
		


	public boolean scheduleIdValidation(String scheduleId) throws InvalidScheduleIdException{
		if(validation.scheduleIdIsValid(scheduleId))
			return true;
		else
			throw new InvalidScheduleIdException("Given Id is Invalid ");
		}
	
	
	public boolean arrivalTimeValidation(String arrTime) throws InvalidTimeException{
		if(validation.timeIsValid(arrTime))
			return true;
		else
			throw new InvalidTimeException("Given time is Invalid, it does not match with the required format hh:mm ");
	}
	
	public boolean departureTimeValidation(String departTime) throws InvalidTimeException{
		if(validation.timeIsValid(departTime))
			return true;
		else
			throw new InvalidTimeException("Given time is Invalid, it does not match with the required format hh:mm ");
	}
	
	public boolean departureDateValidation(String departDate) throws InvalidDateException{
		if(validation.dateIsValid(departDate))
			return true;
		else
			throw new InvalidDateException("Given date is Invalid, it does not match with the required format dd-mm-yyyy ");
	}
	
	public boolean arrivalDateValidation(String arrivalDate) throws InvalidDateException{
		if(validation.dateIsValid(arrivalDate))
			return true;
		else
			throw new InvalidDateException("Given date is Invalid, it does not match with the required format dd-mm-yyyy ");
	}
	
	public boolean schedulePriceValidation(String price) throws InvalidPriceException{
		if(validation.priceIsValid(price))
			return true;
		else
			throw new InvalidPriceException("Given price is Invalid ");
	}

	
}	
