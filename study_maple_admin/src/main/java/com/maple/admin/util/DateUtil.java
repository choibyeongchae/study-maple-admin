package com.maple.admin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static String todayDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		String today = dateFormat.format(calendar.getTime());
		
		return today;
	}
}
