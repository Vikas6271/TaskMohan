package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Library.Utility;


public class OurprojectTestNG 
{

	File F1;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	String productname;
	String price;
	String url;
	WebDriver driver;
	Actions act = new Actions(driver);
	
	
	@Test(priority=1)
	public void Excellread() throws Throwable
	{

		 F1=new File("C:\\Users\\PrathimaKandela\\Desktop\\oourproject.xlsx");
		 fis = new FileInputStream(F1);
		 wb = new XSSFWorkbook(fis);
		 ws = wb.getSheet("Sheet1");
		int rowcount = ws.getLastRowNum();
		int colcount = ws.getRow(0).getLastCellNum();
		System.out.println("rowcount="+rowcount);
		System.out.println("colcount="+colcount);
		url = ws.getRow(1).getCell(0).getStringCellValue();
		System.out.println("url="+url);
		
	}
	@Test(priority=7)
	public void Excellrite() throws Throwable
	{
		ws.getRow(1).createCell(1).setCellValue(productname);
		ws.getRow(1).createCell(2).setCellValue(price);
		FileOutputStream fos = new FileOutputStream(F1);
		wb.write(fos);
		wb.close();
		fos.close();
	}
	@Test(priority=2)
	public void Login() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("vikas.kandela@gmail.com");
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("flip7224");
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
	}
	@Test(priority=3)
	public void Jeans() throws Throwable
	{
		WebElement men = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]"));
		act.moveToElement(men).build().perform();
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/ul/li/ul/li[2]/ul/li[9]/a/span")).click();
		List<WebElement> jeans = driver.findElements(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a[2]"));
		XSSFSheet ws1=wb.getSheet("Sheet2");
		ws1.createRow(0).createCell(0).setCellValue("Jeans");
		for(int i = 0 ; i<=jeans.size()-1 ; i++)
		{
			String Name = jeans.get(i).getText();
			System.out.println("Name="+Name);
			
			ws1.createRow(i+1).createCell(0).setCellValue(Name);
			
		}
		WebElement jeans1 = driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/div[1]/div/a[2]"));
		act.contextClick(jeans1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		String Parentwindow = driver.getWindowHandle();
		Utility.capturescreenshot(driver, Parentwindow);
		System.out.println("Parentwindow="+Parentwindow);
		Set<String> S1 = driver.getWindowHandles();
		System.out.println("total handles="+S1);
		Iterator<String> I1 = S1.iterator();
		while(I1.hasNext())
		{
			String Childwindow = I1.next();
			if (!Parentwindow.equalsIgnoreCase(Childwindow));
			{
				driver.switchTo().window(Childwindow);
			}
		}
		driver.findElement(By.xpath(".//*[@id='swatch-0-size']/a")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/ul/li[1]/button")).click();
	}
	@Test(priority=4)
	public void Againbacktohome() throws Throwable
	{
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div/div[2]/div/div/div[1]/a/img")).click();
		Thread.sleep(5000);
	}
	@Test(priority=5)
	public void Shirt() throws Throwable
	{
		WebElement men1 = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]"));
		act.moveToElement(men1).build().perform();
		WebElement shirt = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/ul/li/ul/li[2]/ul/li[3]/a/span"));
		act.contextClick(shirt).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		String parentwindow1 = driver.getWindowHandle();
		System.out.println("parentwindow1="+parentwindow1);
		Set<String> S2 = driver.getWindowHandles();
		System.out.println("total handles="+S2);
		Iterator<String> I2 = S2.iterator();
		int count=0;
				while(I2.hasNext())
				{
					String childwindow1 = I2.next();
					if(count==3)
					{
						driver.switchTo().window(childwindow1);
					}
				}
				List<WebElement> shirts =driver.findElements(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a[2]"));
				XSSFSheet ws2 = wb.getSheet("Sheet3");
				ws2.createRow(0).createCell(0).setCellValue("Shirts");
				for(int j=0 ; j<=shirts.size()-1;j++)
				{
					String Name1 = shirts.get(j).getText();
					System.out.println("ShirtName="+Name1);
					
					ws2.createRow(j+1).createCell(0).setCellValue(Name1);
				}
	}
	@Test(priority=6)
	public void CheckingCart()
	{
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/a")).click();
		productname = driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/a")).getText();
		price = driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]")).getText();
		System.out.println("product name in cart="+productname);
		System.out.println("price in cart="+price);
	}
	}
