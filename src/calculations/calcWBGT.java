package calculations;
import java.util.Calendar;
import java.util.TimeZone;

public class calcWBGT
{

   public static void main (String[] args)
   {

	   //Location Copenhagen
        double latitude = 55.67594;     
        double longitude = 12.56553;
        
        int year = 2018;
        int month = 1; 
        int day = 21;
        int hour = 12; //Local time
        int min = 00;
        int avg = 10;
        double solar = 200; //Solindstråling
        double pres = 1013; // barometric pressure, mb 
        double Tair = 25;
        double relhum = 50; /* relative humidity, % */
        double speed = 2; //Wind speed (m/s) measured in height zspeed m
        double zspeed = 2;
        double dT = 0; //Vertical temp difference
        int urban = 0;


      //Date and time for calculation
      Calendar calendar = Calendar.getInstance();
      calendar.set(year, month - 1, day, hour, min);
      calendar.setTimeZone(TimeZone.getDefault());
      
      int utcOffset = (calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET)) / (60 * 60000); // Total offset (geographical and daylight savings) from UTC in hours

      // Year, month, day
     
      WBGT wbgt = new WBGT(year, month, day, hour, min, utcOffset, avg, latitude, longitude, solar, pres, Tair, relhum, speed, zspeed, dT, urban);

      //Test solar calculations
/*      Solar s = new Solar(longitude, latitude, calendar, utcOffset);
      System.out.println("Julian century:" + s.julianCentury());
      s.gamma();
      s.equationOfTime();
      s.declination();
      s.tst();
      s.ha();
      s.zenith();
      s.azimuth();
      s.printAll();*/

     
   }	
   
   
}