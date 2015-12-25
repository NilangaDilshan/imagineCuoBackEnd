package com.excelResearchers.utils;

import javax.validation.constraints.Null;

import com.excelResearchers.BasicConfigs;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.MongoClient;




public enum MongoResourceUtil 
{ 
	INSTANCE; 
	private MongoClient mongoClient; 
	//private Properties properties; 
	private MongoResourceUtil() 
	{ 
		try 
		{ 
			/*if (properties == null) 
			{ 
				try { 
					properties = loadProperties(); 
					} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
					} 
				} */
			if (mongoClient == null) mongoClient = getClient(); 
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
			} 
		} 
		/*private static Properties loadProperties() throws IOException 
		{
			Properties properties = new Properties(); 
			InputStream inputStream = MongoResource.class.getResourceAsStream("/mongoDbConfigs/mongodb.properties"); 
			if (inputStream == null) 
			{ 
				throw new FileNotFoundException("not loaded!"); 
				} 
			properties.load(inputStream); return properties; 
			} */
		@Null 
		private MongoClient getClient() 
		{ 
			try 
			{ 
				return new MongoClient( BasicConfigs.props.getProperty("mongo.db.host"), Integer.valueOf(BasicConfigs.props.getProperty("mongo.db.port"))); 
				} 
			catch (Exception e) 
			{ 
				e.printStackTrace(); 
			} 
			return null; 
		} 
		@Null 
		public Datastore getDatastore() 
		{ 
			Datastore ds; 
		// with authentication? 
		if (!BasicConfigs.props.getProperty("mongo.db.username").isEmpty() && !BasicConfigs.props.getProperty("mongo.db.password").isEmpty()) 
		{ 
			ds = new Morphia(). createDatastore(mongoClient,BasicConfigs.props.getProperty("mongo.db.Name"), BasicConfigs.props.getProperty("mongo.db.username"), BasicConfigs.props.getProperty("mongo.db.password").toCharArray()); 
			} 
		else { 
			ds = new Morphia(). createDatastore(mongoClient,BasicConfigs.props.getProperty("mongo.db.Name")); 
			} 
		return ds; 
		} 
} //- See more at: http://www.wegtam.net/article/use-wrapper-class-and-create-one-single-mongoclient-your-java-application#sthash.kCLN6YYf.dpuf


//http://www.wegtam.net/article/use-wrapper-class-and-create-one-single-mongoclient-your-java-application