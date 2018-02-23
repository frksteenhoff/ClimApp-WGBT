package test;
import calculations.WBGT;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class TestSystemTime {

	static Calendar calobj = Calendar.getInstance();
	GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
	
	//Location Copenhagen
	static double latitude = 55.67594;     
	static double longitude = 12.56553;

	static int year = 2018;
	static int month = 1; 
	static int day = 21;
	static int hour = 12; 		// Local time
	static int min = 00;
	static int avg = 10;
	static double solar = 200; // Solindstråling
	static double pres = 1013; // barometric pressure, mb 
	static double Tair = 25;
	static double relhum = 50; // relative humidity, % 
	static double speed = 2; 	//Wind speed (m/s) measured in height zspeed m
	static double zspeed = 2;
	static double dT = 0; 		//Vertical temp difference
	static int urban = 0;

    int utcOffset = (calobj.get(Calendar.ZONE_OFFSET) + calobj.get(Calendar.DST_OFFSET)) / (60 * 60000); // Total offset (geographical and daylight savings) from UTC in hours
	
    WBGT wbgt = new WBGT(year, month, day, hour, min, utcOffset, avg, latitude, longitude, solar, pres, Tair, relhum, speed, zspeed, dT, urban);

	@Test
	void testWGBTCalculations() {
		//WBGT(year, month, day, hour, minute, utcOffset, avg, lat, lon, solar, pres, Tair, relhum, speed, zspeed, dT, urban);
	}

	@Test
	void testSystemCalendar() {
		assertEquals(2018, calobj.get(Calendar.YEAR));

		// February is month 1, as the calendar is zero-indexed
		assertEquals(1, calobj.get(Calendar.MONTH));	
	}

	/*@Test
	void testDayNum() {
	    // Checking that the returned day number is equal to variable "day"
		assertEquals(21, wbgt.noDayOfYear(year, month, day));
		assertEquals(2, wbgt.noDayOfYear(year, month, 2));	
	}*/
	
	@Test
	void proveCalendar() {
		// On leap years, setting too high a value for a month is handled 
		// Here we have the second day of march, as last day in Feb is the 28th
		calobj.set(1992, 1, 31, hour, min);
		assertEquals(2, calobj.get(Calendar.DAY_OF_MONTH));
		
		// Months are zero-indexed therefore March = 2
		assertEquals(2, calobj.get(Calendar.MONTH));
		
		// Check that the February 31st = 2nd of March in 1992 = 31 + 28 + 3
		// Because of leap year
		assertEquals(62, calobj.get(Calendar.DAY_OF_YEAR));
		
		// Using Gregorian Calendar removes need of daynum method
		assertEquals(true, cal.isLeapYear(1992));
	}
}
