package actions;

import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import functionalComponents.ExcelDataReader;
import siteFactory.SiteFactory;

@SuppressWarnings("unchecked")
public class DemoWebShop_Login_Actions extends ExcelDataReader
{
	SiteFactory factory;
	HashMap<String, Object> excelData;
	HashMap<String, List<HashMap<String, String>>> Login_SheetData;
			
	public DemoWebShop_Login_Actions(SiteFactory factory) 
	{
		this.factory = factory;
		excelData = ExcelDataReader.loadData().get("Excel_File");
		Login_SheetData = (HashMap<String, List<HashMap<String, String>>>) excelData.get("Login_Sheet");	
	}
	
	public void clickOnLoginLink()
	{
		factory.DemoWebShop_Login_Pages().clickOnLoginLink();
	}

	public void Login(String data) throws IOException
	{
		
		String emailID = getColumnValue(Login_SheetData,data,"Email_ID");
		String password = getColumnValue(Login_SheetData,data,"Password");
   	

		factory.DemoWebShop_Login_Pages().enterEmail(emailID);
		factory.DemoWebShop_Login_Pages().enterPassword(password);
	}

	public void clickOnLoginBtn()
	{
		factory.DemoWebShop_Login_Pages().clickOnLoginButton();
	}

}
