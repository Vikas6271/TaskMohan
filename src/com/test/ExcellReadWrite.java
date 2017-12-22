package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExcellReadWrite
{
	File F1;
	FileInputStream Fis;
	XSSFWorkbook Wb;
	XSSFSheet Ws;
	String url;
	String username;
	String password;
	int i;
	
public void Excell() throws Throwable
{
	F1= new File("C:\\Users\\PrathimaKandela\\Desktop\\Excellreadwrite.xlsx");
	Fis = new FileInputStream(F1);
	Wb= new XSSFWorkbook(Fis);
	Ws= Wb.getSheet("Sheet1");
	int rowcount = Ws.getLastRowNum();
//	int cellcount = Ws.getRow(1).getLastCellNum();
	for(i=1;i<=rowcount;i++)
	{
		url=Ws.getRow(i).getCell(0).getStringCellValue();
		username=Ws.getRow(i).getCell(1).getStringCellValue();
		password=Ws.getRow(i).getCell(2).getStringCellValue();
		 LaunchApp();
	}
	FileOutputStream Fos = new FileOutputStream(F1);
	Wb.write(Fos);
	Wb.close();
	Fos.close();
}
public void LaunchApp()
{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys(username);
	driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(password);
	driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
	String welcome = driver.getCurrentUrl();
	
	if(welcome.contains("/dashbord"))
	{
		System.out.println("Login Sucessfully");
		Ws.getRow(i).createCell(3).setCellValue("Pass");
		driver.close();
	}
	else
	{
		System.out.println("Login Failed");
		Ws.getRow(i).createCell(3).setCellValue("Fail");
		driver.close();
	}
		
}

	public static void main(String[] args) throws Throwable
	{
		ExcellReadWrite ERW = new ExcellReadWrite();
		ERW.Excell();
	}
}
