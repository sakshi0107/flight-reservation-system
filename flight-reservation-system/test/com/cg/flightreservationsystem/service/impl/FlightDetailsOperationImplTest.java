package com.cg.flightreservationsystem.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.flightreservationsystem.exception.InvalidCapacityInputException;
import com.cg.flightreservationsystem.exception.InvalidFlightIdInputException;
import com.cg.flightreservationsystem.utility.Validation;

public class FlightDetailsOperationImplTest {
	Validation validate = new Validation();

	@Test
	public void testIdValidation() throws InvalidFlightIdInputException 
	{
		boolean actual = validate.idIsValid("fa-101");
		assertEquals(true, actual);
	}

	@Test(expected = InvalidFlightIdInputException.class)
	public void testForWrongIdValidation() throws InvalidFlightIdInputException {
		validate.idIsValid("-1015486");
	}
	
	@Test
	public void testcapacityIsValid() throws InvalidCapacityInputException{
		
		boolean actual = validate.capacityIsValid("400");
		assertEquals(true, actual);
	}
	
	@Test(expected = InvalidCapacityInputException.class)
	public void testIncorrectcapacityIsValid() throws InvalidCapacityInputException{
		
		validate.capacityIsValid("400@");
		
	}
}
