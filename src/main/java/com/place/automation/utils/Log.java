	package com.place.automation.utils;
	
	import org.apache.log4j.Logger;
	
	//Implement from - https://www.toolsqa.com/selenium-webdriver/log4j-logging/
	//https://howtodoinjava.com/log4j/how-to-configure-log4j-using-xml-configuration/
	
	public class Log {
	
		private static Logger Log = Logger.getLogger(Log.class.getName());
		
		// This is to print log for the beginning of the test case, as we usually run so
		// many test cases as a test suite
		public static void startTestCase(String sTestCaseName) {
			Log.info("****************************************************************************************");
			Log.info("------------------                 " + sTestCaseName + "       -------------------------");
			Log.info("****************************************************************************************");
		}

		// This is to print log for the ending of the test case
	
		public static void endTestCase(String sTestCaseName) {
			Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
			Log.info("X");
			Log.info("X");
		}
	
		// Need to create these methods, so that they can be called
	
		public static void info(String message) {
			Log.info(message);
		}
	
		public static void warn(String message) {
			Log.warn(message);
		}
	
		public static void error(String message) {
			Log.error(message);
		}
	
		public static void fatal(String message) {
			Log.fatal(message);
		}
	
		public static void debug(String message) {
			Log.debug(message);
		}
	}