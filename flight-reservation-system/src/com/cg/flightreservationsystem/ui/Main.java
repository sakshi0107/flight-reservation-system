package com.cg.flightreservationsystem.ui;

import java.util.Scanner;
import com.cg.flightreservationsystem.dto.FlightDTO;
import com.cg.flightreservationsystem.dto.RouteDTO;
import com.cg.flightreservationsystem.dto.ScheduleDTO;
import com.cg.flightreservationsystem.exception.EmptyListException;
import com.cg.flightreservationsystem.exception.InvalidCapacityInputException;
import com.cg.flightreservationsystem.exception.InvalidCityInputException;
import com.cg.flightreservationsystem.exception.InvalidDateException;
import com.cg.flightreservationsystem.exception.InvalidFlightIdInputException;
import com.cg.flightreservationsystem.exception.InvalidPriceException;
import com.cg.flightreservationsystem.exception.InvalidRouteIdException;
import com.cg.flightreservationsystem.exception.InvalidScheduleIdException;
import com.cg.flightreservationsystem.exception.InvalidTimeException;
import com.cg.flightreservationsystem.service.FlightDetailsOperations;
import com.cg.flightreservationsystem.service.FlightRouteOperations;
import com.cg.flightreservationsystem.service.FlightScheduleOperations;
import com.cg.flightreservationsystem.service.impl.FlightDetailOperationImpl;
import com.cg.flightreservationsystem.service.impl.FlightRouteOperationImpl;
import com.cg.flightreservationsystem.service.impl.FlightScheduleOperationImpl;
import com.cg.flightreservationsystem.staticdb.Flightdb;
import com.cg.flightreservationsystem.staticdb.Routedb;
import com.cg.flightreservationsystem.staticdb.Scheduledb;


public class Main {
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the XYZ Air Travels Limited....");
		System.out.println("--------------------------------------------");
		System.out.println("welcome admin");
		System.out.println("You can perform following operations: ");
		
		do{
		System.out.println("1. Add Flight Details");
		System.out.println("2. Delete Flight Details");
		System.out.println("3. Add Flight schedule Details");
		System.out.println("4. Delete Flight schedule Details");
		System.out.println("5. Add Flight Route Details");
		System.out.println("6. Delete Flight Route Details");
		System.out.println("Please choose one Option: ");
		String option = scanner.next();
		
		switch (option)
		{
		case "1":
			
			System.out.println("You choosed option 1...welcome ");
			System.out.println("Enter the flightId");
			String flightId = scanner.next();
			System.out.println("Enter plane Capacity");
			String capacity = scanner.next();
			FlightDTO flight = new FlightDTO(flightId,capacity);
			
			try 
			{
			FlightDetailsOperations flightDetailsOperations = new FlightDetailOperationImpl();
			flightDetailsOperations.add(flight);
			System.out.println("New flight details added successfully!!!!");
			System.out.println(Flightdb.flightList);
			}
			
			catch(EmptyListException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			
			catch(InvalidFlightIdInputException e)
			{
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;	
			}
			
			catch(InvalidCapacityInputException e) 
			{
				System.out.println(e.getMessage());
				System.out.println("Please try again!!");
				System.out.println("-----------------------");
				continue;	
			}
			catch(NullPointerException e) {
				System.out.println("This does not contain data");
				System.out.println("-----------------------");
				continue;
			}
			
			break;
		
		case "2":
			
			
			System.out.println("You choosed option 2...welcome ");
			System.out.println("Enter the flightId");
			String flightID = scanner.next();
			
			FlightDTO flightDTO = new FlightDTO(flightID);
			try 
			{
				FlightDetailsOperations flightDetailsOperations2 = new FlightDetailOperationImpl();
				flightDetailsOperations2.delete(flightDTO);
				System.out.println("flight details deleted successfully!!!!");
				System.out.println("-----------------------");
			}
			catch(EmptyListException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			
			catch(InvalidFlightIdInputException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(NullPointerException e) {
				System.out.println("This does not contain data");
				System.out.println("-----------------------");
				continue;
			}
			break;
			
		case "3": 
			
			System.out.println("You choosed option 3...welcome ");
			System.out.println("Enter the scheduleId");
			String scheduleId = scanner.next();
			
			System.out.println("Enter departure time");
			String departureTime = scanner.next();
			
			System.out.println("Enter arrival time");
			String arrivalTime = scanner.next();
			
			System.out.println("Enter departure Date");
			String departureDate = scanner.next();
			
			System.out.println("Enter arrival date");
			String arrivalDate = scanner.next();
			
			System.out.println("Enter price ");
			String price = scanner.next();
			ScheduleDTO schedule = new ScheduleDTO(scheduleId, departureTime, arrivalTime, departureDate, arrivalDate, price);
			try 
			{
			FlightScheduleOperations flightScheduleOperations = new FlightScheduleOperationImpl();
			flightScheduleOperations.add(schedule);
			System.out.println(Scheduledb.scheduleList);
			System.out.println("schedule details added successfully!!!!");
			}
			catch(EmptyListException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(NullPointerException e) {
				System.out.println("This does not contain data");
				System.out.println("-----------------------");
				continue;
			}
			catch(InvalidScheduleIdException e) {
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;
			}
			catch(InvalidTimeException e) {
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;
			}
			catch(InvalidDateException e) {
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;
			}
			catch(InvalidPriceException e) {
				System.out.println(e.getMessage());
				System.out.println("Please try again!!");
				System.out.println("-----------------------");
				continue;
			}
			break;
			
		
		case "4":
			FlightScheduleOperations flightScheduleOperations2 = new FlightScheduleOperationImpl();
			System.out.println("You choosed option 4...welcome ");
			System.out.println("Enter the scheduleId");
			String scheduleID = scanner.next();
			ScheduleDTO scheduleDTO =new ScheduleDTO(scheduleID) ;
			try 
			{
				flightScheduleOperations2.delete(scheduleDTO);
				System.out.println("schedule details deleted successfully!!!!");
			}
			catch(NullPointerException e) {
				System.out.println("This does not contain data");
				System.out.println("-----------------------");
				continue;
			}
			catch(EmptyListException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(InvalidScheduleIdException e)
			{
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;
			}
			
			break;
		
		case "5":
			
			System.out.println("You choosed option 5...welcome!! ");
			System.out.println("Enter the routeId");
			String routeId = scanner.next();
			
			System.out.println("Enter source city");
			String sourceCity = scanner.next();
			
			System.out.println("Enter destination city");
			String destinationCity = scanner.next ();
			RouteDTO route = new RouteDTO(routeId,sourceCity, destinationCity);
			
			try {
			FlightRouteOperations flightRouteOperations = new FlightRouteOperationImpl();
			flightRouteOperations.add(route);
			System.out.println(Routedb.routeList);
			System.out.println("Route details added successfully!!!!");
			}
			catch(EmptyListException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			
			catch(InvalidRouteIdException e)
			{
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;
			}
			catch(InvalidCityInputException e) {
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;
			}
			catch(NullPointerException e)
			{
				System.out.println("This does not contain data");
				System.out.println("-----------------------");
				continue;
			}
			
			break;
		
		
		case "6":
			
			System.out.println("You choosed option 6...welcome ");
			System.out.println("Enter the routeId");
			String routeID = scanner.next();
			RouteDTO routeDTO = new RouteDTO(routeID);
			try {
				FlightRouteOperations flightRouteOperations2 = new FlightRouteOperationImpl();
				flightRouteOperations2.delete(routeDTO);
				System.out.println("Route details deleted successfully!!!!");
				
			}
			catch(EmptyListException e)
			{
				System.out.println(e.getMessage());
				continue;
			}
			catch(InvalidRouteIdException e)
			{
				System.out.println(e.getMessage());
				System.out.println("-----------------------");
				continue;
				
			}
			
			
		case "7":
			System.exit(0);
			
		default:
			System.out.println("you have entered invalid choice....");
			System.out.println("Please try again");
			System.out.println("------------------------------------");
		}
		
	}while(true);

	

	
}
}
