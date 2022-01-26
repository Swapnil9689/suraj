package com.qa.testCases;

import org.testng.annotations.Test;

import com.qa.pageLayer.HomePage;
import com.qa.testBase.TestBase;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	
	HomePage h;
	@Test
	public void verifySearchbox()
	{
		h=new HomePage();
		h.enterText();
		h.clickOnSearch();
	}
	
	@Test
	public void verifyTitle()
	{
		h.getTitle();
		
		Assert.assertEquals("The title is matched", "My Store", h.getTitle());
	}

}
