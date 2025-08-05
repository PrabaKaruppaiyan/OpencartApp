package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTest extends BaseClass {
	
	/* Data is valid-->login success-->test pass
	 * Data is valid-->login failed-->test fail
	 * 
	 * Data is invalid-->login success-->test fail
	 * Data is invalid-->login failed-->test pass
	 * 
	 */
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String expectedResult)
	{
		logger.info("***Starting Login Validation Using DDT ***");
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(expectedResult);
		//Home Page
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.click_login();
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pwd);
		lp.clickLogin();
		
		//My Account Page
		MyAccountPage myAccPage=new MyAccountPage(driver);
		
		switch(expectedResult)
		{
		case "valid":
			          System.out.println(expectedResult);
			          System.out.println(myAccPage.isMyAccountDisplayed());
			          if(myAccPage.isMyAccountDisplayed())
			          {
			        	System.out.println(expectedResult);
			        	myAccPage.clickMyaccount();
			        	myAccPage.logout();
			        	System.out.println(expectedResult);
			        	Assert.assertTrue(true);
			           }
			          else
			        	  Assert.fail();
			          break;
		case "invalid":
			          System.out.println(expectedResult);
			          if(myAccPage.isMyAccountDisplayed())
			          {
			        	  myAccPage.clickMyaccount();
			              myAccPage.logout();
			        	  Assert.assertTrue(false);
			          }
			          else
			        	  Assert.assertTrue(true);
			          break;
	     default:
	    	       Assert.fail();
		}
		logger.info("***TC003_LoginTest Ended");
	}
  
}
