package siteFactory;

import org.openqa.selenium.WebDriver;

import actions.*;
import functionalComponents.CommonFunctions;
import pages.*;

public class SiteFactory 
{

	public WebDriver driverObject() 
	{
		return CommonFunctions.driver;
	}

	public CommonFunctions Commonfunction() 
	{
		return new CommonFunctions();
	}

	public DemoWebShop_Login_Actions DemoWebShop_Login_Actions() 
	{
		return new DemoWebShop_Login_Actions(this);
	}

	public DemoWebShop_Login_Page DemoWebShop_Login_Pages() 
	{
		return new DemoWebShop_Login_Page(this, driverObject());
	}

	public DemoWebShop_Register_Actions DemoWebShop_Register_Actions() 
	{
		return new DemoWebShop_Register_Actions(this);
	}

	public DemoWebShop_Register_Page DemoWebShop_Register_Pages() 
	{
		return new DemoWebShop_Register_Page(this, driverObject());
	}

}
