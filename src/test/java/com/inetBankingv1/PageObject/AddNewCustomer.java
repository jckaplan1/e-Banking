package com.inetBankingv1.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	WebDriver driver;

	public AddNewCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement Cname;

	@FindBy(xpath = "//input[2][@name='rad1']")
	@CacheLookup
	WebElement fgenderbtn;
	@FindBy(xpath = "//input[1][@name='rad1']")
	@CacheLookup
	WebElement mgenderbtn;

	@FindBy(how = How.NAME, using = "dob")
	@CacheLookup
	WebElement DOB;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement address;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement PIN;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement phonenu;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement email;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement subbtn;

	public void addNCustomer() {
		addNewCustomer.click();

	}

	public void addCName(String name) {
		Cname.sendKeys(name);
	}

	public void SelectGender(String gndr) {

		if (gndr.equals("male")) {
			mgenderbtn.click();
		} else if (gndr.equals("female")) {
			fgenderbtn.click();
		}
	}

	public void sendDOB(String yy, String mm, String dd) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		System.out.println(DOB.getText());
		DOB.sendKeys(yy);
//		Thread.sleep(3000);

		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
//		Action dateAction = act.moveToElement(DOB).sendKeys(yy).sendKeys(Keys.ARROW_RIGHT).build();
//		dateAction.perform();
//		Action date = act.moveToElement(DOB).sendKeys(yy).sendKeys(Keys.TAB).sendKeys(mm).sendKeys(dd).build();
//		date.perform();
	}

	public void sendAddress(String addrr) {

		address.sendKeys(addrr);

	}

	public void sendCity(String cit) {

		city.sendKeys(cit);

	}

	public void sendState(String stat) {

		state.sendKeys(stat);

	}

	public void sendPin(String pn) {

		PIN.sendKeys(pn);

	}

	public void sendPhoneNo(String Phn) {

		phonenu.sendKeys(Phn);

	}

	public void sendEmail(String eml) {

		email.sendKeys(eml);

	}

	public void subMit() {

		subbtn.click();

	}

}
