package com.cg.flightreservationsystem.exception;

//custom exception class for checking of price
public class InvalidPriceException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidPriceException(String price)
	{
		super(price);
		// TODO Auto-generated constructor stub
	}

}
