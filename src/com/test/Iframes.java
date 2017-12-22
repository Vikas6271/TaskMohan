package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Iframes 
{
	public static void main(String[] args) 
	{	
		WebDriver driver = new FirefoxDriver();
		driver.get("https://paytm.com/");
		driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]")).click();
		int Frame = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Totel number of frames in page = " +Frame);
		for (int i = 0; i<=Frame; i++)
		{
			driver.switchTo().frame(i);
			if(driver.findElements(By.xpath("//li[text()='Sign In with Paytm']")).size()!=0);
			driver.findElement(By.xpath("//input[@id='input_0']")).sendKeys("9052854858");
			driver.findElement(By.xpath("//input[@id='input_1']")).sendKeys("gopi009");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.switchTo().defaultContent();
		}
	}
}
