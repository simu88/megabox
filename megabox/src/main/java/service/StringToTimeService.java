package service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToTimeService {
	public static Timestamp transformTime(String time) throws ParseException {

        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date date = (Date) df.parse(time);
        long result = date.getTime();

        Timestamp ts = new Timestamp(result);
        
        return ts;
	}
}
