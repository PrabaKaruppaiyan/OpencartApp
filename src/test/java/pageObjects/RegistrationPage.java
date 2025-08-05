package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	  WebElement first_name;
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	 WebElement last_name;
	@FindBy(xpath="//*[@id=\"input-email\"]")
	 WebElement email;
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	 WebElement telephone;
	@FindBy(xpath="//*[@id=\"input-password\"]")
	 WebElement password;
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	 WebElement password_confirm;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	 WebElement chkPolicy;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	 WebElement btnContinue;
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	 WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		first_name.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		last_name.sendKeys(lname);
	}
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	public void setContact(String tel)
	{
		telephone.sendKeys(tel);
	}
	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void confirmpwd(String pwd)
	{
		password_confirm.sendKeys(pwd);
	}
	
	public void checkPolicy()
	{
		chkPolicy.click();
	}
	public void buttonClick()
	{
		//method1
		btnContinue.click();
		/*//method 2
		btnContinue.submit();
		//method 3
		btnContinue.sendKeys(Keys.RETURN);
		//method 4
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnContinue);
	    //method 5
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();*/
	}
	public String getConfirmationMessage()
	{
		try {
		return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}

}
