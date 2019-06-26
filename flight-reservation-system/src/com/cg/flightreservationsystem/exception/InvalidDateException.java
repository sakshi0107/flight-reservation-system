package com.cg.flightreservationsystem.exception;

//custom exception class for checking of date 
public class InvalidDateException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidDateException(String date)
	{
		super(date);
		// TODO Auto-generated constructor stub
	}

}
