package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Iphone 
{
	public static void main(String[] args) throws Throwable 
	{
		 WebDriver driver = new FirefoxDriver ();
	        driver.get("https://www.flipkart.com/");
	        //driver.switchTo().alert().dismiss();
	        driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	        driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("apple");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/ul/li[1]/a")).click();
	        driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[1]")).click();
	        
	        List <WebElement> Applelist = driver.findElements(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[3]/div[1]/div[1]"));
	        List<WebElement> Pricelist = driver.findElements(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[3]/div[2]/div[1]/div/div[1]"));
	        
	        for(int i=0;i<=Applelist.size()-1;i++)
	        {
	            String Name=Applelist.get(i).getText();
	            
	            String Price=Pricelist.get(i).getText();
	            System.out.println("Name = "+Name+"                   "+"Price::"+Price);
	        }
	}

}
