package com.bookmyshow.pages;



import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookmyshow.utils.FileIO;



public class HomePage {
	
	public WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;
	//initialize the elements of the Page Object or instantiate the Page Objects
	
	public HomePage(WebDriver driver){
		this.driver=driver;	
		this.wait = new WebDriverWait(driver,15);
		prop=FileIO.initProperties();
	}
	
	
	//get url of the current page
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	//clicking the required location. xpath is taken from the properties file.
	public void selectArea(String city) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		List <WebElement> cityList = driver.findElements(By.xpath(prop.getProperty("citylist")));
		for(WebElement w:cityList) {
			if(w.getText().equalsIgnoreCase(city)) {
				w.click();
				break;
			}
		}
		
		
		
		
	}
			
	//clicking "not now" in the popup. xpath is taken from the properties file.
	public void popup() throws IOException
	{
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("notnow")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ele.click();
	}
	
	//clicking the signin button. xpath is taken from the properties file.
	public void signinButton() throws IOException
	{
		WebElement element = driver.findElement(By.xpath(prop.getProperty("signin")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}

	//clicking the continue-via-google button. xpath is taken from the properties file.
	public void selectContinueViaGoogle() throws IOException
	{
		WebElement element = driver.findElement(By.xpath(prop.getProperty("continueviagoogle")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	//clicking the continue-via-google button. xpath is taken from the properties file.
	public void selectContinueViaEmail() throws IOException
	{
		WebElement element = driver.findElement(By.xpath(prop.getProperty("continueviaemail")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}


	//signing in to bookmyshow by handling the windows
	public void validsignin(WebDriver driver, String strUserName, String strPassword) throws IOException, InterruptedException{

		Set<String> ids=driver.getWindowHandles();
		Iterator<String> itr=ids.iterator();
		String main=itr.next();
		String join=itr.next();
		driver.switchTo().window(join);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	

		this.setUserName(strUserName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.clicknext();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().window(main);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void invalidsignin(WebDriver driver, String strUserName, String strPassword) throws IOException, InterruptedException{

		Set<String> ids=driver.getWindowHandles();
		Iterator<String> itr=ids.iterator();
		String main=itr.next();
		String join=itr.next();
		driver.switchTo().window(join);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	

		this.setUserName(strUserName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.clicknext();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.xpath(prop.getProperty("warningmessage")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String errormessage = element.getText();

		System.out.println(errormessage);
		System.out.println("********************************************************************");

		driver.close();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().window(main);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void invalidUserName(WebDriver driver, String strUserName, String strPassword) throws IOException, InterruptedException{

		Set<String> ids=driver.getWindowHandles();
		Iterator<String> itr=ids.iterator();
		String main=itr.next();
		String join=itr.next();
		driver.switchTo().window(join);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	

		this.setUserName(strUserName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		this.clicknext();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String errormessage = "Continue button not enabled";

		System.out.println(errormessage);
		System.out.println("********************************************************************");

		driver.close();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().window(main);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	//entering the username using sendkeys. xpath is taken from the properties file.
	public void setUserName(String strUserName) throws IOException{
		WebElement emailid = driver.findElement(By.xpath(prop.getProperty("emailid")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		emailid.clear();
		emailid.sendKeys(strUserName);
	}

	//clicking next after entering the username. xpath is taken from the properties file.
	public void clicknext() throws IOException{
		WebElement element = driver.findElement(By.xpath(prop.getProperty("emailnext")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	/*
	public static void main(String args[]) throws IOException{
		System.setProperty("webdriver.edge.driver","D:\\JAVA\\Java Programs\\Deleting Skills Set\\Drivers\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://bookmyshow.com");
		HomePage h=new HomePage(driver);
		h.selectArea("Chennai");
		/*
		h.signinButton();
		h.selectContinueViaEmail();
		h.setUserName("ekanshjain1999@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		h.clicknext();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//h.click_Sports();
		System.out.println("Success2");
	}
	*/
	
}
