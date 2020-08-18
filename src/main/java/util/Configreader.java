package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	public static String getPropertyValue(String key) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("E:\\MyWorkspace\\Assignmentproject\\Config.properties"));
		
		return property.getProperty(key);
		
	}
	
}
