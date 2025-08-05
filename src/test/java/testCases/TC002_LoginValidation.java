package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginValidation extends BaseClass {
	
	@Test(groups={"Sanity", "Master"})
	public void loginVerify()
	{
		logger.info("***Starting Login Validation Testing***");
		try {
		HomePage home=new HomePage(driver);
		home.clickMyaccount();
		logger.info("MyAccount Link is clicked");
		home.click_login();
		logger.info("Clicked on Login Link");
		
		LoginPage login_page=new LoginPage(driver);
		login_page.enterEmail(p.getProperty("email"));
		logger.info("Email Address passed");
		login_page.enterPassword(p.getProperty("password"));
		logger.info("Password passed");
		login_page.clickLogin();
		logger.info("Clicked on Login");
		
		MyAccountPage myAccPage=new MyAccountPage(driver);
		Assert.assertTrue(myAccPage.isMyAccountDisplayed());
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	} 
	

}
