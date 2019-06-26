package com.cg.flightreservationsystem.exception;

//custom exception class for checking value of schedule-id
public class InvalidScheduleIdException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidScheduleIdException(String id)
	{
		super(id);
		// TODO Auto-generated constructor stub
	}

}
