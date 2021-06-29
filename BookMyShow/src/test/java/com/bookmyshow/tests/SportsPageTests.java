package com.bookmyshow.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bookmyshow.base.BaseUI;
import com.bookmyshow.pages.HomePage;
import com.bookmyshow.pages.SportsPage;
@Listeners(com.bookmyshow.utils.ListenerUtils.class)
public class SportsPageTests {
	
	HomePage objHomePage;
	SportsPage objSportsPage;
	//driver initialization
	public static WebDriver driver;
	
	@BeforeClass
	public void prints() {
		System.out.println("********************************************************************");
		System.out.println("TESTS FOR SPORTS PAGE");
		System.out.println("********************************************************************");
	}
	
	@BeforeTest
	public void setup()throws IOException, InterruptedException {
		
		driver=BaseUI.invokeBrowser();
		driver.get(BaseUI.setUrl());
		objHomePage= new HomePage(driver);
		objHomePage.popup();
		objHomePage.selectArea("Chennai"); 
		objSportsPage = new SportsPage(driver);
		objSportsPage.click_Sports();
	}
	
	@Test(groups="Smoke")
	public void Test_Sports_Is_Clicked() throws IOException, Exception, InterruptedException
	{
		
		
		
			//comparing the actual value with the expected value
			Assert.assertTrue(driver.getCurrentUrl().contains("sports"));
			
		
	}
	
	@Test(groups="Regression")
	public void Test_Sports_Available_Are_Displayed() throws IOException, Exception, InterruptedException
	{
		
		try {
			
			String result = objSportsPage.gettitle();
			if(result.equals("Not displayed"))
				System.out.println("Sports activities changed");
			else
				System.out.println("Sports displayed");
		
		}
		catch(NullPointerException e) {
			
		}
	}
	
	@Test(groups="Smoke")
	public void Test_Weekend_Is_clicked() throws IOException, Exception, InterruptedException
	{	
		
		
		try {
			
			//calling the selectweekend() method in SportsPage
			objSportsPage.selectWeekend();
			
		}
		catch(IOException e)
		{
			
		}
	}
	
	@Test(dependsOnMethods="Test_Weekend_Is_clicked",groups="Regression")
	public void Test_Sports_Availabe_Are_Displayed_After_Selecting_Weekend() throws IOException, Exception, InterruptedException
	{
	
		
		try {
			
			
			String result = objSportsPage.gettitle();
			if(result.equals("Not displayed"))
				System.out.println("Sports activities changed");
			else
				System.out.println("Sports displayed");
		} catch (Exception e) {
			
		}
	}
	
	@Test(groups="Smoke")
	public void Test_PriceRange_Is_clicked() throws IOException, Exception, InterruptedException
	{
		
		
		try {
			//calling clickPriceRange() method in SportsPage class
			objSportsPage.clickPriceRange();
			
		}
		catch(IOException e)
		{
			
		}
	}
	
	@Test(dependsOnMethods="Test_PriceRange_Is_clicked",groups="Smoke")
	public void Test_Minimum_Is_clicked() throws IOException, Exception, InterruptedException
	{

		try {
			
			//calling clickMinimumRange) method in SportsPage class
			objSportsPage.clickMinimumRange();
			
	
		}
		catch (IOException e) {
			
		}
	}
	
	@Test(dependsOnMethods="Test_Minimum_Is_clicked",groups="Regression")
	public void Test_Sports_Availabe_Are_Displayed_After_Selecting_MinimumRange() throws IOException, Exception, InterruptedException
	{

		
		try {
			
			String sports = objSportsPage.gettitle();
			if(sports.equalsIgnoreCase("Not Displayed")) 
				System.out.println("Sports activities changed");
				else
					System.out.println("Sports displayed");
			
		}
		catch (Exception e) {
			
		}
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	
	
}
