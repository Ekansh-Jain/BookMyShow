package com.bookmyshow.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookmyshow.utils.FileIO;


public class MoviesPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public static Properties prop;
	
	//initialize the elements of the Page Object or instantiate the Page Objects
	public MoviesPage(WebDriver driver){
		this.driver=driver;
		this.wait = new WebDriverWait(driver,30);
		prop=FileIO.initProperties();
	}
	
	//navigating back to movies page by handling windows.
	public void navigateToMoviesPage_and_Click_Movies() throws InterruptedException, IOException {
		
		//Click on movies button
		WebElement element = driver.findElement(By.linkText(prop.getProperty("movies")));
		element.click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		
		//clicking on coming soon
		element = driver.findElement(By.xpath(prop.getProperty("exploreupcoming")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
		
	}
	
	//check whether the movies are displayed
	public String checkMoviesAreDisplayed() throws IOException, InterruptedException
	{
		String Movie;
		//checks whether the movie results are displayed
		List <WebElement> movieResults = driver.findElements(By.xpath(prop.getProperty("moviedisplay")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(movieResults.size()!=0)
			Movie="Displayed";
		else
			Movie="Not Displayed";
		
		return Movie;
	}
	
	//extracting the languages from menu items and storing in a list
	public int extractLanguage() throws IOException, InterruptedException {
		
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		
		//Perform Click on Movies button using JavascriptExecutor
		executor2.executeScript("window.scrollBy(0,450)");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		//creating object fro list
		List<WebElement> languagesElement =driver.findElements(By.xpath(prop.getProperty("languages")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<String>languages = new ArrayList<String>();
		for(WebElement w:languagesElement)
			languages.add(w.getText());
		
		System.out.println("********************************************************************");
		//printing the values stored in the list
		System.out.println(languages);
		
		int size = languages.size();
		return size;
		
	}
	
	public void displayLanguagesList()
	{
		System.out.println("********************************************************************");
		System.out.println("Languages Are Displayed");
		System.out.println("********************************************************************");
	}
	
	/*
	public static void main(String args[]) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver","D:\\JAVA\\Java Programs\\Deleting Skills Set\\Drivers\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://bookmyshow.com");
		HomePage h=new HomePage(driver);
		h.selectArea("Chennai");
		MoviesPage m=new MoviesPage(driver);
		m.navigateToMoviesPage_and_Click_Movies();
		System.out.println(m.checkMoviesAreDisplayed());
		System.out.println(m.extractLanguage());
		driver.quit();
	}
	*/
	
}
