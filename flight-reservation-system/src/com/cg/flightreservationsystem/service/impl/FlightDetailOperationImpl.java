package com.cg.flightreservationsystem.service.impl;
import java.util.List;

import com.cg.flightreservationsystem.dto.FlightDTO;
import com.cg.flightreservationsystem.exception.EmptyListException;
import com.cg.flightreservationsystem.exception.InvalidCapacityInputException;
import com.cg.flightreservationsystem.exception.InvalidFlightIdInputException;
import com.cg.flightreservationsystem.service.FlightDetailsOperations;
import com.cg.flightreservationsystem.staticdb.Flightdb;
import com.cg.flightreservationsystem.utility.Validation;

public class FlightDetailOperationImpl implements FlightDetailsOperations {
	Validation validation = new Validation();
	Flightdb flightData = new Flightdb();
	FlightDTO flightDto = new FlightDTO();

	public boolean add(FlightDTO flight) throws InvalidFlightIdInputException, InvalidCapacityInputException,EmptyListException
	{
		String flightID = flight.getFlightId();
		String flightCapacity = flight.getCapacity();
		idValidation(flightID);
		capacityValidation(flightCapacity);
		
		boolean flag = false;
		List<FlightDTO> flightList = Flightdb.getflightList();
		if(flightList == null || flightList.isEmpty()) {
			throw new EmptyListException("Flight List is empty");
		}
		else
		{
			for(FlightDTO flightDTO: flightList)
			{
				if(flightDTO.getFlightId().equals(flightID)) {
					throw new InvalidFlightIdInputException("id already exists, enter Another id");
				}
					else {
					flightDTO.setCapacity(flightCapacity);
					flag = true;
					break;
				}
			}
		
			return flightData.add(flight);
	}	
	}
		
	public boolean delete(FlightDTO flight) throws InvalidFlightIdInputException, EmptyListException{
			String flightID = flight.getFlightId();
			idValidation(flightID);

				boolean flag = false;
				List<FlightDTO> flightList = Flightdb.getflightList();
				if(flightList == null || flightList.isEmpty()) {
					throw new EmptyListException("Flight List is empty");
				}
				else
				{
					for(FlightDTO flightDTO: flightList)
					{
						if(!(flightDTO.getFlightId().equals(flightID))){
							throw new InvalidFlightIdInputException("id does not exist, enter Another id");
						}
						else {
							flag=true;
							break;
						}
					}
				}
				return flightData.delete(flight);
	}
		
		public boolean idValidation(String flightId) throws InvalidFlightIdInputException{
			if(validation.idIsValid(flightId))
				return true;
			else
				throw new InvalidFlightIdInputException("You have incorrect format of flight-id, please try again!! ");
		}
		
		public boolean capacityValidation(String flightCapacity) throws InvalidCapacityInputException{
			if(validation.capacityIsValid(flightCapacity))
				return true;
			else
				throw new InvalidCapacityInputException("You have entered incorrect format of capacity, please try again!! ");
		}
	}

