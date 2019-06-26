package com.cg.flightreservationsystem.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.flightreservationsystem.exception.InvalidCityInputException;
import com.cg.flightreservationsystem.exception.InvalidRouteIdException;
import com.cg.flightreservationsystem.utility.Validation;

public class FlightRouteOperationImplTest {
	Validation validate = new Validation();
	
	@Test
	public void testrouteIdIsValid() throws InvalidRouteIdException {
		boolean actual = validate.routeIdIsValid("ro-101");
		assertEquals(true, actual);
	}
	
	@Test(expected = InvalidRouteIdException.class)
	public void test1routeIdIsValid() throws InvalidRouteIdException {
		validate.routeIdIsValid("route");
		
	}
	
	@Test
	public void testcityIsValid() throws InvalidCityInputException {
		boolean actual = validate.cityIsValid("Mumbai");
		assertEquals(true, actual);
	}
	
	@Test(expected = InvalidCityInputException.class)
	public void test1cityIsValid() throws InvalidCityInputException {
		validate.cityIsValid("Mumbai!@");
		
	}
	

}
