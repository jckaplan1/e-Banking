package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBankingv1.PageObject.AddNewCustomer;
import com.inetBankingv1.PageObject.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {

	AddNewCustomer ANC;

	@Test
	public void AddNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.userName(username);
		lp.userPassword(password);
		lp.loginBtn();

		ANC = new AddNewCustomer(driver);
		logger.info("Addcustomer is clicked.");
		ANC.addNCustomer();
		logger.info("Name is entered.");
		ANC.addCName("Jamal");
		logger.info("gender is selected");
		ANC.SelectGender("male");

		ANC.sendDOB("1987  ", "02", "16");
		ANC.sendAddress("266 N Wolfe Road \n " + "Apt 830");
		ANC.sendCity("Sunnyvale");
		ANC.sendState("California");
		ANC.sendPin("950500");
		ANC.sendPhoneNo("6584567895");
		String emails = randomString() + "@gmail.com";
		ANC.sendEmail(emails);
		ANC.subMit();

	}

}
