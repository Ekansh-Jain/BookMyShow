package com.bookmyshow.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookmyshow.utils.FileIO;


public class SportsPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public static Properties prop;
	
	
	//initialize the elements of the Page Object or instantiate the Page Objects
	public SportsPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver,15);
		prop=FileIO.initProperties();
	}
	
	//select weekend and the required xpath is taken from the properties file.
	public void selectWeekend() throws IOException {
		WebElement element = driver.findElement(By.xpath(prop.getProperty("weekend")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	//click price-range dropdown box. the required xpath is taken from the properties file.
	public void clickPriceRange() throws IOException {
		WebElement element = driver.findElement(By.xpath(prop.getProperty("pricerange")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	//select minimum range from the dropdown box. the required xpath is taken from the properties file.
	public void clickMinimumRange() throws IOException {
		WebElement element = driver.findElement(By.xpath(prop.getProperty("min")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	//getting the name of the sports activity displayed. the required xpath is taken from the properties file.
	public String gettitle()  {
		List<WebElement> sportsElement =driver.findElements(By.xpath(prop.getProperty("sportstitle")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(sportsElement.size()!=0) {
			ArrayList<String>sports = new ArrayList<String>();
			for(WebElement w:sportsElement)
				sports.add(w.getText());
			return sports.get(0);
		}
		
		return "Not displayed";
		
	}
	
	
	public void click_Sports() throws  IOException 
	{
		WebElement element = driver.findElement(By.cssSelector(prop.getProperty("sports")));
		element.click();
		
	}
	
	/*
	public static void main(String args[]) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver","D:\\JAVA\\Java Programs\\Deleting Skills Set\\Drivers\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://bookmyshow.com");
		HomePage h=new HomePage(driver);
		h.selectArea("Chennai");
		SportsPage s=new SportsPage(driver);
		s.click_Sports();
		s.selectWeekend();
		System.out.println(s.gettitle()+"1");
		s.clickPriceRange();
		System.out.println(s.gettitle()+"2");
		s.clickMinimumRange();
		System.out.println(s.gettitle()+"3");
		driver.quit();
	}
	*/
}