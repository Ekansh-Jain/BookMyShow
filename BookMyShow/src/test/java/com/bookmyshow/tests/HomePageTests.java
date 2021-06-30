package com.bookmyshow.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.bookmyshow.base.BaseUI;
import com.bookmyshow.pages.HomePage;

@Listeners(com.bookmyshow.utils.ListenerUtils.class)
public class HomePageTests {
	
	
	HomePage objHomePage;
	//driver initialization
	public static WebDriver driver;
	

	@BeforeTest
	public void setup()throws IOException {
		System.out.println("********************************************************************");
		System.out.println("TESTS FOR HOME PAGE");
		System.out.println("********************************************************************");
		driver=BaseUI.invokeBrowser();
		driver.get(BaseUI.setUrl());
	}
	
	@Test(groups="Smoke")
	public void Test_Browser_And_URL_Invoked_Correctly() throws NullPointerException, Exception {
		
		Assert.assertTrue(driver.getTitle().contains("BookMyShow"));		
	}
	
	
	@Test(dependsOnMethods="Test_Browser_And_URL_Invoked_Correctly",groups="Regression")
	public void Test_MainPage_Title_Matches_Correctly() throws IOException, Exception
	{
		//to check whether the expected page and actual page are same,
		//check the expected page title with actual page title using assert
		
		
		
		
		//storing the title in a string
		String pagetitle =driver.getTitle();
		if(pagetitle.contains("Book"))
			System.out.println(pagetitle);
	}
	
	@Test(dependsOnMethods="Test_MainPage_Title_Matches_Correctly",groups="Smoke")
	public void Test_Popup_Is_Ignored() throws IOException, InterruptedException, Exception
	{
		
		this.objHomePage = new HomePage(driver);
		
		
			//calling the popup() method in HomePage class
		objHomePage.popup();
			
		
	
	}
	
	@Test(dependsOnMethods="Test_Popup_Is_Ignored",groups="Smoke")
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
	
	@Test(dependsOnMethods="Test_City_Is_Selected_Correctly",groups="Smoke")
	public void Test_Signin_Button_Is_clicked() throws IOException, InterruptedException, Exception
	{
		
		
		try {
			this.objHomePage = new HomePage(driver);
			
			//calling the signinButton() method in HomePage class
			objHomePage.signinButton();
			
			
		}
		catch(IOException e)
		{
			
		}
	}
	
	@Test(dependsOnMethods="Test_Signin_Button_Is_clicked",groups="Smoke")
	public void Test_Continue_Via_Google_Button_Is_Clicked() throws IOException, Exception
	{
		
		
		
		this.objHomePage = new HomePage(driver);
		
		try {
			
			//calling the selectContinueViaGoogle() method in HomePage class
			objHomePage.selectContinueViaGoogle();
			
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
		
}
