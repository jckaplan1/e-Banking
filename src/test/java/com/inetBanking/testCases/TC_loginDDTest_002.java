package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.testUtilties.XLUtils;
import com.inetBankingv1.PageObject.LoginPage;

public class TC_loginDDTest_002 extends BaseClass {

	@Test(dataProvider = "loginData")
	public void loginTest(String userN, String pswd) throws IOException {

		LoginPage lp = new LoginPage(driver);
		lp.userName(userN);
		lp.userPassword(pswd);
		lp.loginBtn();
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			captureScreen(driver, "LoginTest");

		} else {
			Assert.assertTrue(true);
			driver.navigate().refresh();
//			driver.switchTo().frame("aswift_0");
//			driver.switchTo().alert().dismiss();
			lp.logOut();

			driver.navigate().back();
		}

	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "loginData")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/login.xlsx/";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", rownum);

		String loginData[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colnum; j++) {

				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}

		}
		return loginData;
	}

}
