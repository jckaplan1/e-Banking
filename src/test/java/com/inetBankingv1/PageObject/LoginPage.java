package com.inetBankingv1.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	@CacheLookup
	WebElement usernam;
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement pawd;
	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement lgnbtn;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[10]/a")
	@CacheLookup
	WebElement logout;

	@FindBy(xpath = "//*[@id='cbb']/svg/path")
	@CacheLookup
	WebElement add;

	public void userName(String uname) {
		usernam.sendKeys(uname);
	}

	public void userPassword(String upaswd) {
		pawd.sendKeys(upaswd);
	}

	public void loginBtn() {
		lgnbtn.click();
	}

	public void logOut() {
		logout.click();
	}

	public void add() {
		add.click();
	}

}
