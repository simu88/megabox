package service;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class StringToDateService {
	
	public static Date transformDate(String release_date) {
		Date date = new Date(0);
		
		SimpleDateFormat simpledate = new SimpleDateFormat(release_date + "");
		
		String formatedDate = simpledate.format(date);
		
		java.sql.Date releaseDate = java.sql.Date.valueOf(formatedDate);
		
		return releaseDate;
	}
	
	

}
