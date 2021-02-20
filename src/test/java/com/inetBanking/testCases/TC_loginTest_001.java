package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.inetBankingv1.PageObject.LoginPage;

public class TC_loginTest_001 extends BaseClass {

	public LoginPage lp;

	@Test
	public void Login() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		String bsu = "http://demo.guru99.com/V1/index.php";

		logger.info("username is entered.");
		lp.userName(username);
		logger.info("Password is entered.");
		lp.userPassword(password);
		logger.info("Login button clicked");
		lp.loginBtn();

		String title = driver.getTitle();
		SoftAssert sasrt = new SoftAssert();
		if (title.equals("GTPL Bank Manager HomePage ")) {
			sasrt.assertTrue(true);
			logger.info("The title is correct and login test passed");
			System.out.println("The title mtches correctly which is " + title);
		} else {
			sasrt.assertTrue(false);
			logger.info("The title is not correct loggin failed.");
			System.out.println("The title does not match");
			captureScreen(driver, "Login");
		}
	}

}
