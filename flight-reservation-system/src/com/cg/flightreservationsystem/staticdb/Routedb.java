package com.cg.flightreservationsystem.staticdb;

import java.util.ArrayList;
import java.util.List;
import com.cg.flightreservationsystem.dto.RouteDTO;
import com.cg.flightreservationsystem.exception.InvalidRouteIdException;

public class Routedb {
	public static List<RouteDTO> routeList = new ArrayList<RouteDTO>();
	static {
		Routedb.routeList.add(new RouteDTO("ro-101", "Mumbai", "Pune"));
		Routedb.routeList.add(new RouteDTO("ro-102", "Mumbai", "Delhi"));
		Routedb.routeList.add(new RouteDTO("ro-103", "Mumbai", "Goa"));
		Routedb.routeList.add(new RouteDTO("ro-104", "Pune", "Mumbai"));
		Routedb.routeList.add(new RouteDTO("ro-105", "Pune", "Goa"));
		Routedb.routeList.add(new RouteDTO("ro-106", "Pune", "Delhi"));
		Routedb.routeList.add(new RouteDTO("ro-107", "Pune", "Delhi"));
		Routedb.routeList.add(new RouteDTO("ro-108", "Delhi", "Pune"));
		Routedb.routeList.add(new RouteDTO("ro-109", "Delhi", "Mumbai"));
		Routedb.routeList.add(new RouteDTO("ro-110", "Goa", "Mumbai"));
		Routedb.routeList.add(new RouteDTO("ro-106", "Goa", "Delhi"));
	}
	
	public boolean add(RouteDTO route) throws InvalidRouteIdException {
		return Routedb.routeList.add(route);
	}
		
	public boolean delete(RouteDTO route) throws InvalidRouteIdException {
			return Routedb.routeList.remove(route);		
	}
	public static List<RouteDTO> getrouteList() {
		return routeList;
	}
	
}
