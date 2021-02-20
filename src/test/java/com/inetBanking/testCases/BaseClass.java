package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.testUtilties.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseurl = readConfig.getBaseUrl();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String brows) {
		logger = Logger.getLogger("e-Banking");
		PropertyConfigurator.configure("Log4j.properties");
//		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		if (brows.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (brows.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
		driver.manage().window().maximize();

	}

//	@AfterClass
	public void tearDown() {
		driver.quit();

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot takescreen = (TakesScreenshot) driver;
		File src = takescreen.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken");

	}

	public String randomString() {
		String email = RandomStringUtils.randomAlphabetic(6);
		return email;

	}

}
