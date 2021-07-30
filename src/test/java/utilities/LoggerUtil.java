package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
	
	public static Logger getLogger(Class<?> cls) {
		PropertyConfigurator.configure("log4j.properties");
		return Logger.getLogger(cls);
	}
	
	// Created for testing
	public static void main(String[] args) {
		Logger log  = LoggerUtil.getLogger(LoggerUtil.class);
		log.debug("info");
	}

}
