package Library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Utility 
{
	public static void capturescreenshot(WebDriver driver, String ScreenshotName) throws Exception
	{
		try
		{
			TakesScreenshot TS = (TakesScreenshot)driver;
			File Source = TS.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File("Screenshot\\"+ScreenshotName+".png"));
			System.out.println("Screenshot Taken");
		} 
		catch (Exception e) 
		{
			System.out.println("exception while taking screenshot"+e.getMessage());
		}
	}

	
	public static void highlight(By by,WebDriver driver)
	{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        try
        {
	        WebElement ele = driver.findElement(by);
	        for(int i = 1;i<=5;i++)
	        {
	        	Thread.sleep(1000);
		        js.executeScript("arguments[0].style.border='solid 4px black'", ele);
				Thread.sleep(1000);
		        js.executeScript("arguments[0].style.border=''", ele);
	        }
        }
        catch(Exception e)
        {
        	
        }
	}
}
