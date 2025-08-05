package testBaseSample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass1 {
	public Logger logger;
	public Properties p;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }
	@BeforeClass(groups={"Sanity","Regression","Master","Datadriven"})
	@Parameters({"browser","os"})
	public void setup(String browser, String os) throws IOException
	{
	    //Loading config.properties file
		FileReader file=new FileReader(".//src//test/resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());
			break;
		case "edge":
			driver.set(new EdgeDriver());
			break;
		case "firefox":
			driver.set(new FirefoxDriver());
			break;
		default:
			     System.out.println("Invalid Browser");
			     return;
		}
	
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		getDriver().get(p.getProperty("appURL"));
		getDriver().manage().window().maximize();
	}
	@AfterClass(groups={"Sanity","Regression","Master","Datadriven"})
	public void tear_down()
	{
		//driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(7);
		return(generatedString);
	}
	public String randomNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return(generatedString);
	}
	public String randomAlphaNumeric()
	{
		String generatedString=RandomStringUtils.randomAlphanumeric(10);
		return(generatedString);
	}
	public String captureScreen(String tname) throws IOException {

	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}

}
