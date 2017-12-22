package com.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle 
{
	public static void main(String[] args) throws Throwable
	{	
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("html/body/div[2]/div/div/button")).click();
		Actions action =new Actions(driver);
		WebElement gift= driver.findElement(By.xpath("//a[text()='Gift Card']"));
		action.contextClick(gift).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(10000);
		String Parentwindow = driver.getWindowHandle();
		System.out.println(Parentwindow);
		Set<String> S1 = driver.getWindowHandles();
		System.out.println(S1);
		
		Iterator<String> I1 = S1.iterator();
		while(I1.hasNext())
		{
			String Childwindow = I1.next();
			if (!Parentwindow.equalsIgnoreCase(Childwindow));
			{
				driver.switchTo().window(Childwindow);
				String fstout=driver.findElement(By.xpath("//span[text()='Flipkart Gift Card']")).getText();
				System.out.println(fstout);
			}
		}
	}
}
