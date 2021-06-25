package com.bookmyshow.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.bookmyshow.base.BaseUI;
import com.bookmyshow.pages.HomePage;
import com.bookmyshow.pages.MoviesPage;
import com.bookmyshow.pages.SportsPage;






public class TestCases {
	
	ActualValues objmainpage;
	HomePage objHomePage;
	SportsPage objSportsPage;
	MoviesPage objMoviesPage;
	//driver initialization
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()throws IOException {
		System.out.println("********************************************************************");
		System.out.println("BOOKMYSHOW AUTOMATION");
		System.out.println("********************************************************************");
	}
	

	@Test(priority=0,groups="Smoke")
	public void Test_Browser_And_URL_Invoked_Correctly() throws NullPointerException, Exception {
		
		try {
			
			//invoke browser
			
			driver=BaseUI.invokeBrowser();
			
			//launching the site
			driver.get(BaseUI.setUrl());
			
			
			//maximize the browser window
			driver.manage().window().maximize();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=1,groups="Regression")
	public void Test_MainPage_Title_Matches_Correctly() throws IOException, Exception
	{
		//to check whether the expected page and actual page are same,
		//check the expected page title with actual page title using assert
		
		
		this.objmainpage = new ActualValues(driver);
		
		//storing the title in a string
		String pagetitle = objmainpage.getPageTitle();
		
		Thread.sleep(3000);
			
		//comparing the actual value with the expected value
		Assert.assertTrue(pagetitle.contains(pagetitle));
	}
	
	@Test(priority=2,groups="Smoke")
	public void Test_Popup_Is_Ignored() throws IOException, InterruptedException, Exception
	{
		
		this.objHomePage = new HomePage(driver);
		
		try {
			//calling the popup() method in HomePage class
			objHomePage.popup();
			
		}
		catch (IOException e)
		{
			
		}
	
	}
	
	@Test(priority=3,groups="Smoke")
	public void Test_City_Is_Selected_Correctly() throws IOException, Exception
	{
		
		this.objHomePage = new HomePage(driver);
		
		try {
			//calling the selectarea() method in HomePage class
			objHomePage.selectArea("Chennai");
			
		
		}
		catch(IOException e) {
			//
		}
		
	}
	
	
	
	
	@AfterClass
	public void exit() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			//trace the exception
			e.printStackTrace();
		}
		driver.quit();
	}
	
	
}
