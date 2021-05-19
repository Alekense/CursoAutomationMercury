package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	
	@FindBy(name = "userName")
	private WebElement userFieldElement;
	@FindBy(name = "password")
	private WebElement passwordFieldElement;
	@FindBy(name = "submit")
	private WebElement loginButtonElement;
	@FindBy(tagName = "input")
	private List<WebElement> fields;
	
	private By flightsLink;
		
	public PageLogin (WebDriver driver) {
		this.driver = driver;
		flightsLink = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
		PageFactory.initElements(driver, this);
	}
	
	public void login (String user, String pass) {
		userFieldElement.sendKeys(user);
		passwordFieldElement.sendKeys(pass);
		loginButtonElement.click();
		Helpers.sleep(driver);
	}
	
	public void fields_login(String user, String pass) {
		//List<WebElement> loginFields = driver.findElements(fields);
		fields.get(1).sendKeys(user);
		fields.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyFields() {
		//List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(fields.size());
		Assert.assertTrue(fields.size()==4);
	}
	
	public void flights() {
		driver.findElement(flightsLink).click();
		Helpers.sleep(driver);
	}

}