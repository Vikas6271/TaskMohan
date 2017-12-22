package Apolo;



import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Library.Utility;

public class Module1
{
	public  void Launchbrowser() throws Exception 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.apollohospitals.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Utility.capturescreenshot(driver, "urllaunch");
		WebElement patientcare = driver.findElement(By.xpath(".//*[@id='shadow']/section[3]/header/section[2]/section/section/nav/ul/li[2]/a"));
		Utility.capturescreenshot(driver,"patientcare" );
		Actions act = new Actions(driver);
		act.moveToElement(patientcare).build().perform();
		WebElement value = driver.findElement(By.xpath(".//*[@id='shadow']/section[3]/header/section[2]/section/section/nav/ul/li[2]/ul/li[7]/a"));
		Utility.capturescreenshot(driver, "value");
		act.moveToElement(value).build().perform();
		WebElement book = driver.findElement(By.xpath("//a[text()='Book an Appointment']"));
		Utility.capturescreenshot(driver, "book");
		act.contextClick(book).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		String parentwindow = driver.getWindowHandle();
		Set<String>S1 = driver.getWindowHandles();
		Iterator<String>I1 = S1.iterator();
		while(I1.hasNext())
		{
		String childwindow = I1.next();
		if(!parentwindow.equalsIgnoreCase(childwindow))
		{
			driver.switchTo().window(childwindow);
		}
		}
		WebElement city = driver.findElement(By.xpath(".//*[@id='ddlCity']"));
		Select newcity = new Select(city);
		newcity.selectByVisibleText("Hyderabad");
		Utility.capturescreenshot(driver, "newcity");
		WebElement hospital = driver.findElement(By.xpath(".//*[@id='ddlHospital']"));
		Select newhospital = new Select(hospital);
		newhospital.selectByVisibleText("Apollo Cradle Kondapur");
		Utility.capturescreenshot(driver, "newhospital");
		driver.findElement(By.xpath(".//*[@id='txtSpeDoc']")).sendKeys("Dr");
		Thread.sleep(1000);
		Utility.capturescreenshot(driver, "doc");
		driver.findElement(By.xpath(".//*[@id='ui-id-1']/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='form1']/header/div/div[2]/div/div[1]/div[3]/div/div/button")).click();
		driver.findElement(By.xpath(".//*[@id='MainContent_btnBookAppointment1']")).click();
		try {
			int Frame = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Totel number of frames in page = " +Frame);
			for(int i=0; i<=Frame; i++)
			{
				driver.switchTo().frame(i);
				if(driver.findElements(By.xpath(".//*[@id='divShowLogin']/div[3]")).size()!=0);
				System.out.println("It is a frame");
			}
		} 
		catch (Exception e)
		{
			System.out.println("It is not a frame");
		}
		driver.findElement(By.xpath("html/body/div[6]/div[1]/button")).click();
	}
	public static void main(String[] args) throws Exception
	{
		Module1 M1 = new Module1();
		M1.Launchbrowser();
	}
	
	}

