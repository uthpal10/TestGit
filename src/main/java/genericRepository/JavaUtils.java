package genericRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils 
{
	/**
	 * This method is used to append/generate the random number
	 * @return
	 */
	public int getRandomNum(int num)
	{
		Random ran = new Random();
		int random = ran.nextInt(num);
		return random;
	}
	
	/**
	 * This method is used to get the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	
	/**
	 * This method is used to get the system date in particular format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		Date dt = new Date();
		String date = dateformat.format(dt);	
		return date;
	}
}
