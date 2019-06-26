package com.cg.flightreservationsystem.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.flightreservationsystem.exception.InvalidCapacityInputException;
import com.cg.flightreservationsystem.exception.InvalidCityInputException;
import com.cg.flightreservationsystem.exception.InvalidDateException;
import com.cg.flightreservationsystem.exception.InvalidFlightIdInputException;
import com.cg.flightreservationsystem.exception.InvalidPriceException;
import com.cg.flightreservationsystem.exception.InvalidRouteIdException;
import com.cg.flightreservationsystem.exception.InvalidScheduleIdException;
import com.cg.flightreservationsystem.exception.InvalidTimeException;

public class Validation 
{
	public boolean idIsValid(String id) throws InvalidFlightIdInputException
	{
		Pattern type = Pattern.compile("[f][a][-][0-9]{3}");
		Matcher match = type.matcher(id);
		if (!match.matches()) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}

	public boolean scheduleIdIsValid(String sid) throws InvalidScheduleIdException
	{
		//Pattern type = Pattern.compile("^sc[-][0-9]{3}$");
		Pattern type = Pattern.compile("[s][c][-][0-9]{3}");
		Matcher match = type.matcher(sid);
		if (!match.matches()) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}

	public boolean routeIdIsValid(String rid) throws InvalidRouteIdException 
	{
		Pattern type = Pattern.compile("[r][o][-][0-9]{3}");
		Matcher match = type.matcher(rid);
		if (!match.matches())
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}

	public boolean capacityIsValid(String capacity) throws InvalidCapacityInputException
	{
		Pattern type = Pattern.compile("[1-5]{1}[0-9]{2}");
		Matcher match = type.matcher(capacity);

		if (!match.matches()) 
		{
			return false;
		} 
		else
		{
			return true;
		}
	}

	public boolean timeIsValid(String time) throws InvalidTimeException
	{
		Pattern type = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
		Matcher match = type.matcher(time);
		if (!match.matches()) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}

	public boolean dateIsValid(String date) throws InvalidDateException 
	{
		Pattern type = Pattern.compile("\\d{1,2}-\\d{1,2}-\\d{4}");
		Matcher match = type.matcher(date);
		if (!match.matches()) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}

	public boolean cityIsValid(String city) throws InvalidCityInputException 
	{
		Pattern type = Pattern.compile("[A-Z]{1}[a-z]*");
		Matcher match = type.matcher(city);
		if (!match.matches()) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}

	public boolean priceIsValid(String price) throws InvalidPriceException 
	{
		Pattern type = Pattern.compile("[0-9]{4}");
		Matcher match = type.matcher(price);
		if (!match.matches())
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}

}
