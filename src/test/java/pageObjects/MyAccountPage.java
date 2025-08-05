package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	  WebElement myaccount;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	 WebElement logout;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	 WebElement myacc;
	
	public boolean isMyAccountDisplayed()
	{
		try {
			return(myaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	public void clickMyaccount()
	{
	  myacc.click();	
	}
	
	public void logout()
	{
		logout.click();
	}
}
