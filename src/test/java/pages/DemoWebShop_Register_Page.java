package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import siteFactory.SiteFactory;

public class DemoWebShop_Register_Page extends DemoWebShop_BasePage 
{

	public DemoWebShop_Register_Page(SiteFactory factory,WebDriver driver) 
	{
		super(factory,driver);
	}
	
	protected By register_LnkObj = By.xpath("//a[contains(text(),'Register')]");
	protected By male_genderRadio_btn = By.xpath("//input[@id='gender-male']");
	protected By female_genderRadio_btn = By.xpath("//input[@id='gender-female']");
	protected By FName = By.xpath("//input[@id='FirstName']");
	protected By LName = By.xpath("//input[@id='LastName']");
	protected By EmailId = By.xpath("//input[@id='Email']");
	protected By Pass = By.xpath("//input[@id='Password']");
	protected By ConfPassword = By.xpath("//input[@id='ConfirmPassword']");
	protected By register_btn = By.xpath("//input[@id='register-button' and @value='Register']");
	protected By continue_btn = By.xpath("//input[@value='Continue']");
	protected By logOut_LnkObj = By.xpath("//a[contains(text(),'Log out')]");
	
	public void clickOnRegisterLink()
	{
		unconditionalWait(2);
		findElementAndClick(register_LnkObj);
	}
	
	public void clickOnMaleGenderRadio_Link()
	{
		unconditionalWait(2);
		findElementAndClick(male_genderRadio_btn);
	}
	
	public void clickOnFemaleGenderRadio_Link()
	{
		unconditionalWait(2);
		findElementAndClick(female_genderRadio_btn);
	}
	
	public void enterFirstName(String name)
	{
		unconditionalWait(2);
		findElementAndSendkey(FName, name);
	}
	
	public void enterLastName(String name)
	{
		unconditionalWait(2);
		findElementAndSendkey(LName, name);
	}
	
	public void enterEmail(String EmailID)
	{
		unconditionalWait(2);
		findElementAndSendkey(EmailId, EmailID);
	}
	
	public void enterPassword(String Password)
	{
		unconditionalWait(2);
		findElementAndSendkey(Pass, Password);
	}

	public void enterCnfmPassword(String Password)
	{
		unconditionalWait(2);
		findElementAndSendkey(ConfPassword, Password);
	}

	public void clickOnRegisterButton()
	{
		unconditionalWait(2);
		findElementAndClick(register_btn);
	}

	public void clickOnContinueButton()
	{
		unconditionalWait(2);
		findElementAndClick(continue_btn);
	}
	
	public void clickOnLogOutLink()
	{
		unconditionalWait(2);
		findElementAndClick(logOut_LnkObj);
	}
}
