package com.ajio.generalUtililies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This Repository is used to perform the files common functions
 * @author USER
 *
 */
public class FileRepository 
{
	static Properties property;
	/**
	 * This method is used to open the property file
	 * @param filename
	 */
	public static void openPropertyFile(String filename) 
	{
		FileInputStream fis = null;
		try {
			fis=new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String featchProperties(String key)
	{
		return property.getProperty(key);
	}
}
