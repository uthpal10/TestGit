package genericRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils 
{
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		// Get the java representataion object of the physical file
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
		
		// Create object for properties class to load all the keys
		Properties pObject = new Properties();
		pObject.load(fis);
		
		// Read the values by using get property(key)
		String value = pObject.getProperty(key);
		
		return value;
	}
}
