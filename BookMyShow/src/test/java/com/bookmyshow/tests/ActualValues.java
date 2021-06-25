package com.bookmyshow.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class ActualValues {

	public WebDriver driver;
	
	//initialize the elements of the Page Object or instantiate the Page Objects

	public ActualValues(WebDriver driver){

		this.driver=driver;

	}

	//getting the title for main page and sports page and storing in a string

	public String getPageTitle() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String mainPageTitle=driver.getTitle();

		System.out.println("********************************************************************");

		System.out.println(driver.getTitle());

		System.out.println("********************************************************************");

		return mainPageTitle;

	}

}