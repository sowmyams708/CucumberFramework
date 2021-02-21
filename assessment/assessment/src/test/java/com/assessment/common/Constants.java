package com.assessment.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Constants {
	public static String browser = null;

	public static String chrome_driver_path = null;

	public static String ie_driver_path = null;

	public static String firefox_driver_path = null;

	public static boolean is_initialized = false;

	public static boolean is_initialized_variable = false;

	public static Properties prop = new Properties();

	public static int explicit_wait_time = 0;

	public static int implicit_wait_time = 0;

	public static int page_load_time = 0;

	public static String base_url = null;

	

	public static String prefix1 = null;

	public static String prefix2 = null;

	public static int general_wait_time = 0;

	public static long timestamp_threshold = 0;

	public static String format = "dd-MMM-yyyy HH:mm:ss";

	public static DateFormat dateformat = new SimpleDateFormat(format);

	

}
