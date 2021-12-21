package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import siteFactory.SiteFactory;

public class DemoWebShop_Login_Page extends DemoWebShop_BasePage
{ 
	public DemoWebShop_Login_Page(SiteFactory factory,WebDriver driver) 
	{
		super(factory,driver);
	}
	
	//Log In Link
	protected By logIn_LnkObj = By.xpath("//a[contains(text(),'Log in')]");
	protected By email_Obj = By.xpath("//input[contains(@id,'Email')]");
	protected By password_Obj = By.xpath("//input[contains(@id,'Password')]");
	protected By logIn_BtnObj = By.xpath("//input[contains(@value,'Log in')]");
	
	public void clickOnLoginLink()
	{
		unconditionalWait(2);
		findElementAndClick(logIn_LnkObj);
	}
	
	public void enterEmail(String EmailID)
	{
		unconditionalWait(2);
		findElementAndSendkey(email_Obj, EmailID);
	}
	
	public void enterPassword(String Password)
	{
		unconditionalWait(2);
		findElementAndSendkey(password_Obj, Password);
	}
	
	public void clickOnLoginButton()
	{
		unconditionalWait(2);
		findElementAndClick(logIn_BtnObj);
	}

}
