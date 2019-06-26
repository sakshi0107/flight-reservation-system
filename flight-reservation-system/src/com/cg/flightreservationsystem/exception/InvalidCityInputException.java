package com.cg.flightreservationsystem.exception;

//custom exception class for checking of city values
public class InvalidCityInputException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidCityInputException(String city) 
	{
		super(city);
		// TODO Auto-generated constructor stub
	}

}
