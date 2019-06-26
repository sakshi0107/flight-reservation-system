package com.cg.flightreservationsystem.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.flightreservationsystem.exception.InvalidDateException;
import com.cg.flightreservationsystem.exception.InvalidScheduleIdException;
import com.cg.flightreservationsystem.exception.InvalidTimeException;
import com.cg.flightreservationsystem.utility.Validation;

public class FlightScheduleOperationImplTest {
	Validation validate = new Validation();
	
	@Test
	public void testscheduleIdIsValid() throws InvalidScheduleIdException{
		boolean actual = validate.scheduleIdIsValid("sc-101");
		assertEquals(true, actual);
	}
	
	@Test(expected = InvalidScheduleIdException.class)
	public void test1scheduleIdIsValid() throws InvalidScheduleIdException{
		validate.scheduleIdIsValid("sc@198");
		
	}
	@Test
	public void testtimeIsValid() throws InvalidTimeException{
		boolean actual = validate.timeIsValid("10:10:19");
		assertEquals(true, actual);
	}
	
	@Test(expected = InvalidTimeException.class)
	public void test1timeIsValid() throws InvalidTimeException{
		 validate.timeIsValid("10:10:19");
	}
	
	@Test
	public void testdateIsValid() throws InvalidDateException{
		boolean actual = validate.dateIsValid("10-10-2019");
		assertEquals(true, actual);
	}
	
	@Test(expected = InvalidDateException.class)
	public void test1dateIsValid() throws InvalidDateException{
		validate.dateIsValid("qwr-10-36600");
		
	}
	
	
}
