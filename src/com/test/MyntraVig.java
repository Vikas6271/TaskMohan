package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyntraVig
{
	File F1;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	String url;
	String username;
	String password;
	int i;
	public void Excell() throws Throwable
	{
		F1 = new File("C:\\Users\\PrathimaKandela\\Desktop\\Myntra.xlsx");
		fis= new FileInputStream(F1);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet("Sheet1");
		int rowcount = ws.getLastRowNum();
		for (i=1;i<=rowcount;i++)
		{
			url=ws.getRow(i).getCell(0).getStringCellValue();
			username=ws.getRow(i).getCell(1).getStringCellValue();
			password=ws.getRow(i).getCell(2).getStringCellValue();
			myntra();
		}
		FileOutputStream fos = new FileOutputStream(F1);
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	public void myntra() throws Throwable
	{
		WebDriver driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//input[@placeholder='Your Email Address']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		//driver.findElement(By.xpath("//a[text()='Recover password']"));
		Thread.sleep(10000);
		if (driver.findElement(By.xpath("//a[text()='Recover password']")).isDisplayed())
		{
			System.out.println("Login Failed");
			ws.getRow(i).createCell(3).setCellValue("Fail");
			driver.close();
		}
		else
		{
			System.out.println("login Sucessfull");
			ws.getRow(i).createCell(3).setCellValue("Pass");
			driver.close();
			
		}
			
	}
	
	

	public static void main(String[] args) throws Throwable 
	{	
		MyntraVig mv =new MyntraVig();
		mv.Excell();
	}
}
