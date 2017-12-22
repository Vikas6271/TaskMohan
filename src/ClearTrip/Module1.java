package ClearTrip;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Library.Utility;

public class Module1 
{
	
	File F1;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	String url;
	String from;
	String to;
	WebDriver driver;
	
	
	public void readexcell() throws Throwable
	{
		F1 = new File("C:\\Users\\PrathimaKandela\\Desktop\\Cleartrip.xlsx");
		fis = new FileInputStream(F1);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("Sheet1");
		url = ws.getRow(1).getCell(0).getStringCellValue();
		from=ws.getRow(1).getCell(1).getStringCellValue();
		to = ws.getRow(1).getCell(2).getStringCellValue();
	}
	
	
	public void launchurl() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Utility.capturescreenshot(driver, "urllaunch");
		driver.findElement(By.id("RoundTrip")).click();
		driver.findElement(By.id("FromTag")).sendKeys(from);
		driver.findElement(By.xpath("//ul[@class='autoComplete']//li[1]/a[contains(text(),'Hyderabad')]")).click();
		driver.findElement(By.id("ToTag")).sendKeys(to);
		driver.findElement(By.xpath("//ul[@class='autoComplete']/li[1]/a[contains(text(),'New Delhi')]")).click();
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[7]")).click();
		driver.findElement(By.id("ReturnDate")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[7]/a")).click();
	}
	
	
	public void select()
	{
		WebElement adult = driver.findElement(By.id("Adults"));
		Select newadult = new Select(adult);
		newadult.selectByVisibleText("2");
		
		WebElement child = driver.findElement(By.id("Childrens"));
		Select newchild = new Select(child);
		newchild.selectByVisibleText("2");
		
		WebElement infants = driver.findElement(By.id("Infants"));
		Select newinfants = new Select(infants);
		newinfants.selectByVisibleText("2");
		
		driver.findElement(By.id("SearchBtn")).click();
	}
	
	public void selectflight()
	{
//		String str= "I love India";
//		str.replaceAll("India", "Hyd");
//		System.out.println(str);
		List<WebElement> toflights = driver.findElements(By.xpath(".//*[@id='flightForm']/section[2]/div[4]/div[1]/nav/ul/li/div/label/table/tbody/tr[1]/th[1]/input"));
		int size=toflights.size();
		int count=0;
		for(int i=0;i<=size-1;i++)
			
		{
			count++;
			{
			if (count==2)
			{
				//driver.findElement(By.xpath(".//*[@id='flightForm']/section[2]/div[4]/div[1]/nav/ul/li[2]/div/label/table/tbody/tr[1]/th[1]/input")).click();
				toflights.get(i).click();
			
			}
			}
			
		}
		List<WebElement> fromflights = driver.findElements(By.xpath(".//*[@id='flightForm']/section[2]/div[4]/div[2]/nav/ul/li/div/label/table/tbody/tr[1]/th[1]/input"));
		int siz=fromflights.size();
		int count1=0;
		for(int j=0;j<=siz;j++)
		{
			count1++;
			{
				if (count1==2)
				{
					fromflights.get(j).click();
				}
			}
		}
		
		
	}

	public static void main (String[] args) throws Throwable
	{
		Module1 execute = new Module1();
		execute.readexcell();
		execute.launchurl();
		execute.select();
		execute.selectflight();
	}


}
