package com.viraj.MultipleSelect;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
	WebDriver driver;
	String baseURL = "https://letskodeit.teachable.com/p/practice";
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viraj\\Desktop\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select select = new Select(element);
		
		Thread.sleep(2000);
		
		System.out.println("Select Orange by Value");
		select.selectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("Deselect Orange by value");
		select.deselectByValue("orange");
		
		Thread.sleep(2000);
		System.out.println("Select Peach by index");
		select.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.println("Select Apple by visible text");
		select.selectByVisibleText("Apple");
		
		Thread.sleep(2000);
		System.out.println("Print all selected options");
		List<WebElement> e1 = select.getAllSelectedOptions();
		for(int i = 0; i < e1.size(); i ++) {
			System.out.println(e1.get(i).getText());
		}
		
		Thread.sleep(2000);
		System.out.println("Deselect all selected options");
		select.deselectAll();
				
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}

}
