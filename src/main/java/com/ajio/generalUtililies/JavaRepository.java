package com.ajio.generalUtililies;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaRepository {
	public static String getDate()
	{
		return(new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss").format(new Date()));
		
	}

}
