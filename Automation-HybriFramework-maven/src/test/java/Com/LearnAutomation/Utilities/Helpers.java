package Com.LearnAutomation.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helpers  {
	
	public static WebDriver driver;
	

	public static  String  CaptureScreenShot( )
	{	
		
		String Screenshotpath = System.getProperty("user.dir")+ "/Screenshot/HRM" + getCurrentDateTime()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		
			
		try {
			FileHandler.copy(src, new File("./Screenshot " + getCurrentDateTime()+ ".png"));
			//FileHandler.copy(src, new File(Screenshotpath));
			System.out.println("ScreenShot Captured");
		} 
		
		catch (IOException e) 
		{
			System.out.println("unable to get the message" + e.getMessage());
		}
		return Screenshotpath;
	

		
	}
	
	
	public static String getCurrentDateTime()
	{
		DateFormat Customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");	
		Date currentdate = new Date();
		return Customformat.format(currentdate);
	}
	
	

}
