package com.cg.flightreservationsystem.exception;

//custom exception class for checking time
public class InvalidTimeException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidTimeException(String time) 
	{
		super(time);
		// TODO Auto-generated constructor stub
	}

}
