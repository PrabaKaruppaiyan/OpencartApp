package testBaseSample;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistration1 extends BaseClass1{
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistration*****");
		try {
		HomePage hp=new HomePage(getDriver());
		hp.clickMyaccount();
		logger.info("Clicked on MyAccount");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		RegistrationPage rp=new RegistrationPage(getDriver());
		logger.info("Providing Customer Details");
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString().concat("@yahoo.com"));
		//rp.setEmail(randomString()+"@gmail.com");
		rp.setContact(randomNumber());
		String pwd=randomAlphaNumeric();
		System.out.println(pwd);
		rp.setPwd(pwd);
		rp.confirmpwd(pwd);
		rp.checkPolicy();
		rp.buttonClick();
		logger.info("Clicked on Continue Button");
		String confirm_msg=rp.getConfirmationMessage();
		logger.info("Validating Expected Message");
		//Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");
		if(confirm_msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("debug Logs..");//It will capture all the debug level logs
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();//if assertion fail
		}
		logger.info("***** TC001_AccountRegistration testing Ended*****");
	}
	
	
 
}
