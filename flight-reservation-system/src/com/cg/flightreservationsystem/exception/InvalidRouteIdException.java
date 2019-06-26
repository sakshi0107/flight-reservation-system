package com.cg.flightreservationsystem.exception;

//custom exception class for checking value of route-id
public class InvalidRouteIdException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidRouteIdException(String rid)
	{
		super(rid);
		// TODO Auto-generated constructor stub
	}
	

}
