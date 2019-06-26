package com.cg.flightreservationsystem.service.impl;

import java.util.List;
import com.cg.flightreservationsystem.dto.RouteDTO;
import com.cg.flightreservationsystem.exception.EmptyListException;
import com.cg.flightreservationsystem.exception.InvalidCityInputException;
import com.cg.flightreservationsystem.exception.InvalidRouteIdException;
import com.cg.flightreservationsystem.service.FlightRouteOperations;
import com.cg.flightreservationsystem.staticdb.Routedb;
import com.cg.flightreservationsystem.utility.Validation;

public class FlightRouteOperationImpl implements FlightRouteOperations{
		Validation validation = new Validation();
		Routedb routeData = new Routedb();
		
		public boolean add(RouteDTO route) throws InvalidRouteIdException, InvalidCityInputException, EmptyListException{
			String routeId = route.getRouteId();
			String routeSourceCity =route.getSourceCity();
			String routeDestinationCity = route.getDestinationCity();
			
			routeIdValidation(routeId);
			cityValidation(routeSourceCity);
			cityValidation(routeDestinationCity);
			
			boolean flag = false;
			List<RouteDTO> routeList = Routedb.getrouteList();
			if(routeList == null || routeList.isEmpty()) {
				throw new EmptyListException("Route List is empty");
			}
			else
			{
				for(RouteDTO routeDTO: routeList)
				{
					if(routeDTO.getRouteId().equals(routeId)) {
						throw new InvalidRouteIdException("id already exists, enter Another id");
					}
						else {
						routeDTO.setSourceCity(routeSourceCity);
						routeDTO.setDestinationCity(routeDestinationCity);
						flag = true;
						break;
					}
				}
			
				return routeData.add(route);
		}	
			
		}	
		
		public boolean delete(RouteDTO route) throws InvalidRouteIdException, EmptyListException
		{
			String routeId = route.getRouteId();
			routeIdValidation(routeId);	
			
			boolean flag = false;
			List<RouteDTO> routeList = Routedb.getrouteList();
			if(routeList == null || routeList.isEmpty()) {
				throw new EmptyListException("Route List is empty");
			}
			else
			{
				for(RouteDTO routeDTO: routeList)
				{
					if(!(routeDTO.getRouteId().equals(routeId))) {
						throw new InvalidRouteIdException("id does not exists, enter a valid id");
					}
					else {
						flag = true;
						break;
					}
				}
			
				return routeData.delete(route);
		}	
			
		}
		
			public boolean routeIdValidation(String routeid) throws InvalidRouteIdException{
				if(validation.routeIdIsValid(routeid))
					return true;
				else
					throw new InvalidRouteIdException("You have entered incorrect id, please try again!!");
			}
			
			public boolean cityValidation(String routeStartCity) throws InvalidCityInputException{
				if(validation.cityIsValid(routeStartCity))
					return true;
				else
					throw new InvalidCityInputException("You have entered wrong format of city , please try again!!");
			}
			
			public boolean destinationCityValidation(String routeEndCity) throws InvalidCityInputException{
				if(validation.cityIsValid(routeEndCity))
					return true;
				else
					throw new InvalidCityInputException("You have entered wrong format of city , please try again!! ");
			}


			
}
		

	
	

