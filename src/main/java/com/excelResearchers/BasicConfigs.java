package com.excelResearchers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class BasicConfigs {
	private final static Logger logger = Logger.getLogger(BasicConfigs.class);
	public static Properties props;
	private static String propFileName="/basicProperties.properties";
	
	public void readProperties()
	{
		try {
			setProperties();
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("Basic configuration reading error. "+e.getMessage());
		}
	}
	public static void setProperties() throws IOException
	{
		props = new Properties();
		InputStream inputStream = null;
		if(propFileName!=null)
		{
			try {
				inputStream=BasicConfigs.class.getResourceAsStream(propFileName);
			} catch(Exception ex) {
				logger.info("Property file read error:- "+ex);
			}
		}
		if (inputStream == null) {
			logger.info("Basic Prperty not loaded. File name "+propFileName+".properties!\nPlease rerun the jar file with valid property file arguement.");
			throw new FileNotFoundException("Basic Prperty not loaded. File name "+propFileName+".properties!");
		}
		props.load(inputStream);
	}
}

