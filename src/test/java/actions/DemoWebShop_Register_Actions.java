package actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import functionalComponents.ExcelDataReader;
import siteFactory.SiteFactory;

@SuppressWarnings("unchecked")
public class DemoWebShop_Register_Actions extends ExcelDataReader 
{
	SiteFactory factory;
	HashMap<String, Object> excelData;
	HashMap<String, List<HashMap<String, String>>> Register_SheetData;

	public DemoWebShop_Register_Actions(SiteFactory factory) 
	{
		this.factory = factory;
		excelData = ExcelDataReader.loadData().get("Excel_File");
		Register_SheetData = (HashMap<String, List<HashMap<String, String>>>) excelData.get("Register_Sheet");

	}

	public void clickOnRegisterLink()
	{
		factory.DemoWebShop_Register_Pages().clickOnRegisterLink();
	}

	public void registerUser(String data) throws IOException
	{

		String gender = getColumnValue(Register_SheetData,data,"Gender");
		String fName = getColumnValue(Register_SheetData,data,"First_Name");
		String lName = getColumnValue(Register_SheetData,data,"Last_Name");
		String emailID = getColumnValue(Register_SheetData,data,"Email_ID");
		String password = getColumnValue(Register_SheetData,data,"Password");
		String cnfpassword = getColumnValue(Register_SheetData,data,"Confirm password");

		if(gender.equalsIgnoreCase("Male"))
		{
			factory.DemoWebShop_Register_Pages().clickOnMaleGenderRadio_Link();
		}
		else
		{
			factory.DemoWebShop_Register_Pages().clickOnFemaleGenderRadio_Link();
		}

		factory.DemoWebShop_Register_Pages().enterFirstName(fName);
		factory.DemoWebShop_Register_Pages().enterLastName(lName);
		factory.DemoWebShop_Register_Pages().enterEmail(emailID);
		factory.DemoWebShop_Register_Pages().enterPassword(password);
		factory.DemoWebShop_Register_Pages().enterCnfmPassword(cnfpassword);

	}
	
	public void clickOnRegisterBtn()
	{
		factory.DemoWebShop_Register_Pages().clickOnRegisterButton();
	}

	public void clickOnLogOutlnk()
	{
		factory.DemoWebShop_Register_Pages().clickOnLogOutLink();
	}
	
	public void clickOnContinueBtn()
	{
		factory.DemoWebShop_Register_Pages().clickOnContinueButton();
	}
	
}
