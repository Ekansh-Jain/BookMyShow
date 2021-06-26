package com.bookmyshow.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bookmyshow.base.BaseUI;
import com.bookmyshow.pages.HomePage;

public class SigninWindowTests {
	
	ActualValues objmainpage;
	HomePage objHomePage;
	
	//driver initialization
	public static WebDriver driver;
	
	@BeforeTest
	public void setup()throws IOException {
		System.out.println("********************************************************************");
		System.out.println("TESTS FOR SIGNIN ");
		System.out.println("********************************************************************");
		driver=BaseUI.invokeBrowser();
		driver.get(BaseUI.setUrl());
		objHomePage =new HomePage(driver);
		objHomePage.popup();
		objHomePage.selectArea("Chennai");
		objHomePage.signinButton();
		objHomePage.selectContinueViaGoogle();
	}
	
	
	@Test(groups="Smoke")
	public void Test_Invalid_UserName() throws IOException, InterruptedException, Exception
	{
		
		try {
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.invalidUserName(driver, "abc@123","Hi");
			
			
		}
		catch(IOException e) {
			
		}
	}
	
	
	@Test(groups="Smoke")
	public void Test_Invalid_Password() throws IOException, InterruptedException, Exception
	{
		
		
		try {
			
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.invalidsignin(driver, "dummyemail@gmail.com","hi");
			
			
		}
		catch(IOException e) {
			
		}
	}
	
	@Test(groups="Smoke")
	public void Test_Blank_UserName() throws IOException, InterruptedException, Exception
	{
		
		try {
			
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.invalidUserName(driver, " ","hi");
			
		}
		catch(IOException e) {
			
		}
	}
	
	@Test(groups="Smoke")
	public void Test_Blank_Password() throws IOException, InterruptedException, Exception
	{	
		
		
			
		//getting the username and password from excel and passing as parameters to signin() method in HomePage
		objHomePage.invalidsignin(driver, "dummyemail@gmail.com"," ");
			
		
		
	}
	
	@Test(groups="Smoke")
	public void Test_Signing_In_Appears_Correctly() throws IOException, InterruptedException, Exception
	{
		
		
		try {
			
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.validsignin(driver, "dummyemail@gmail.com","correctpassword");
			
		}
		catch(IOException e) {
			
		}
	}
	
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
