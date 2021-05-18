package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	
	//@FindBy(how=How.NAME,using="userName")
	//private WebElement userFieldElement;
	
	private By userField;
	private By passwordField;
	private By loginButton;
	private By flightsLink;
	private By fields;
	
	public PageLogin (WebDriver driver) {
		this.driver = driver;
		userField = By.name("userName");
		passwordField = By.name("password");
		loginButton = By.name("submit");
		flightsLink = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
		fields = By.tagName("input");
	}
	
	public void login (String user, String pass) {
		//System.out.println(userFieldElement);
		//userFieldElement.sendKeys(user);
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(loginButton).click();		
		Helpers.sleep(driver);
	}
	
	public void fields_login(String user, String pass) {
		List<WebElement> loginFields = driver.findElements(fields);
		loginFields.get(1).sendKeys(user);
		loginFields.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyFields() {
		List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(loginFields.size());
		Assert.assertTrue(loginFields.size()==4);
	}
	
	public void flights() {
		driver.findElement(flightsLink).click();
		Helpers.sleep(driver);
	}

}