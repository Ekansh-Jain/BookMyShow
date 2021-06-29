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
import com.bookmyshow.pages.MoviesPage;
import com.bookmyshow.pages.SportsPage;
@Listeners(com.bookmyshow.utils.ListenerUtils.class)
public class MoviesPageTests {
	
	ActualValues objmainpage;
	HomePage objHomePage;
	SportsPage objSportsPage;
	MoviesPage objMoviesPage;
	//driver initialization
	public static WebDriver driver;
	
	@BeforeClass
	public void prints(){
		System.out.println("********************************************************************");
		System.out.println("TESTS FOR MOVIES PAGE");
		System.out.println("********************************************************************");
	}
	
	@BeforeTest
	public void setup()throws IOException, InterruptedException {
		
		driver=BaseUI.invokeBrowser();
		driver.get(BaseUI.setUrl());
		objHomePage= new HomePage(driver);
		objHomePage.popup();
		objHomePage.selectArea("Chennai"); //DataProvider to be added 
		objMoviesPage = new MoviesPage(driver);
		objMoviesPage.navigateToMoviesPage_and_Click_Movies();
	}
	
	@Test(groups="Smoke")
	public void Test_Window_Navigates_To_Movie_Page() throws IOException, Exception, InterruptedException
	{
		
		Assert.assertTrue(driver.getTitle().contains("Movie"));	
	}
	
	@Test(groups="Regression")
	public void Test_Movies_Are_Displayed() throws IOException, Exception, InterruptedException
	{
		
		this.objMoviesPage = new MoviesPage(driver);
		try {
			//storing the value in a string by calling checkMoviesAreDisplayed() method in MoiesPage
			String result = objMoviesPage.checkMoviesAreDisplayed();
			if(result.equals("Displayed"))
			{
				System.out.println("Results there");
			}
		}
		catch(IOException e)
		{
			
		}
	}
	
	@Test(groups="Smoke")
	public void Test_Languages_Are_Extracted_And_Stored_In_List() throws IOException, Exception, InterruptedException
	{
		
		this.objMoviesPage = new MoviesPage(driver);
		
		try {
			//calling extractLanguages() method in MoviesPage class
			int size = objMoviesPage.extractLanguage();
			
			if(size==14)
			{
				System.out.println("Success Lang");
			}
			else
			{
				System.out.println("Fail Lang");
			}
		}
		catch(IOException e)
		{
			
		}
	}
	
	@Test(groups="Regression")
	public void Test_Languages_Are_Displayed() throws IOException, Exception, InterruptedException
	{	
		this.objMoviesPage = new MoviesPage(driver);
		
		try {
			
			//calling the displayLanguagesList() method in MoviesPage class
			objMoviesPage.displayLanguagesList();
			
			
		}
		catch(NullPointerException e)
		{
			
		}
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
	
	
}
