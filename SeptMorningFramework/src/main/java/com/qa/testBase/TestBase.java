package com.qa.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.utilities.ReadConfig;
import com.qa.utilities.WebDriverListeners;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	ReadConfig readcon= new ReadConfig();
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br)
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if (br.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
		}
		else
		{
			System.out.println("Please enter correct browser name as 'chrome' , 'firefox', 'edge', 'safari'");
		}
		//Listeners
		EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
		WebDriverListeners eventlistener=new WebDriverListeners();
		e_driver.register(eventlistener);
		driver =e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readcon.getApplicationURL());
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
