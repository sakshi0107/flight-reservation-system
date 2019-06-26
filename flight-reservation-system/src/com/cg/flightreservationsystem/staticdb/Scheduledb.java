package com.cg.flightreservationsystem.staticdb;
import java.util.LinkedList;
import java.util.List;
import com.cg.flightreservationsystem.dto.ScheduleDTO;
import com.cg.flightreservationsystem.exception.InvalidScheduleIdException;

public class Scheduledb {
	public static List<ScheduleDTO> scheduleList = new LinkedList<ScheduleDTO>();
	
	static 
	{
		Scheduledb.scheduleList.add(new ScheduleDTO("sc-101", "12:12", "2:01", "2345", "10/12/2019", "10/12/2019"));
		Scheduledb.scheduleList.add(new ScheduleDTO("sc-102", "11:12", "1:10", "2000", "19/2/2019", "19/2/2019"));
		Scheduledb.scheduleList.add(new ScheduleDTO("sc-103", "13:12", "15:50", "2340", "1/1/2019", "/1/2019"));
		Scheduledb.scheduleList.add(new ScheduleDTO("sc-104", "10:12", "11:45", "2500", "30/7/2019", "30/7/2019"));
		Scheduledb.scheduleList.add(new ScheduleDTO("sc-105", "9:12", "10:30", "2900", "18/5/2019", "18/5/2019"));
		Scheduledb.scheduleList.add(new ScheduleDTO("sc-106", "4:11", "8:01", "2800", "24/4/2019", "24/4/2019"));
		Scheduledb.scheduleList.add(new ScheduleDTO("sc-107", "22:12", "1:01", "2700", "26/12/2019", "27/12/2019"));
	}
	
	public boolean add(ScheduleDTO schedule) throws InvalidScheduleIdException 
	{
			return Scheduledb.scheduleList.add(schedule);
	}
	
	public boolean delete(ScheduleDTO schedule) throws InvalidScheduleIdException 
	{
			return Scheduledb.scheduleList.remove(schedule);
	}
	
	public static List<ScheduleDTO> getscheduleList()
	{
		return scheduleList;
	}
}	
