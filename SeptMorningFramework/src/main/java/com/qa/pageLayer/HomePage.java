package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class HomePage extends TestBase {
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement search_box;
	public void enterText()
	{
		search_box.sendKeys("Printed Dress");
	}
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement click_on_search;
	public void clickOnSearch()
	{
		click_on_search.click();
	}
	
	public String getTitle()
	{
		String title=driver.getTitle();
		return title;
	}
}
