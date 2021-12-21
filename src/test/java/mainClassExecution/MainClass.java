package mainClassExecution;

import java.io.IOException;
import org.testng.annotations.Test;
import functionalComponents.CommonFunctions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import siteFactory.SiteFactory;

public class MainClass extends CommonFunctions
{
	
		SiteFactory factory = new SiteFactory();
		
		@BeforeTest
		public void PreRequisite() throws Throwable
		{
			initiateBrowser();		
		}

		@Test
		public void validLogin() throws IOException
		{
			factory.DemoWebShop_Login_Actions().clickOnLoginLink();
			factory.DemoWebShop_Login_Actions().Login("TD_01");		
		}

		@Test
		public void invalidLogin() throws IOException
		{
			factory.DemoWebShop_Login_Actions().clickOnLoginLink();
			factory.DemoWebShop_Login_Actions().Login("TD_02");			
		}

		@AfterTest
		public void postRequisite()
		{

		}

	}