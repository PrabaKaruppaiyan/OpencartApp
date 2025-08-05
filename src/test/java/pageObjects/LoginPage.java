package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
   public LoginPage(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(xpath="//*[@id=\"input-email\"]")
     WebElement email;
   @FindBy(xpath="//*[@id=\"input-password\"]")
     WebElement password;
   @FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
     WebElement login;
   
   public void enterEmail(String email_id)
   {
	   email.sendKeys(email_id);
	   
   }
   
   public void enterPassword(String pwd)
   {
	   password.sendKeys(pwd);
   }
   
   public void clickLogin()
   {
	   login.click();
   }
}
