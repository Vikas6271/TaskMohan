package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop 
{
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/");
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(0);
		WebElement  drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		action.clickAndHold(drag).moveToElement(drop).release(drop).perform();
		action.dragAndDrop(drag, drop).perform();
		driver.switchTo().defaultContent();
		String print = driver.findElement(By.xpath("//a[text()='Sortable']")).getText();
		System.out.println(print);
		driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		
		
		
	}
}
