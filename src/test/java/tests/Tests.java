package tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Tests {
	private WebDriver driver;
	ArrayList<String> tabs;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		driver = new ChromeDriver(options);
		//driver.manage().window().setPosition(new Point(400, 300));
		driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");
		//JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		//String googleWindow = "window.open('http://www.google.com')";
		//javaScriptExecutor.executeScript(googleWindow);
		//tabs = new ArrayList<String>(driver.getWindowHandles());
		Helpers.sleep(driver);
	}
	
	@Test
	public void pruebaUno() {
		//WebDriverManager.setWindowSize(driver, "fullscreen");
		//driver.switchTo().window(tabs.get(1)).navigate().to("https://www.infobae.com/");
		//driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		PageLogon pageLogon = new PageLogon(driver);
		pageLogin.login("user", "user");
		pageLogon.assertLogonPage();				
	}
	
	@Test
	public void pruebaDos() {
		WebDriverManager.setWindowSize(driver, "maximized");
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.flights();
		pageReservation.assertPage();				
	}
	
	@Test
	public void pruebaTres() {
		WebDriverManager.setWindowSize(driver, 800, 600);
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.flights();
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("Frankfurt");		
	}
	
	@Test
	public void pruebaCantidadDeCampos() {		
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields();
		pageLogin.fields_login("user", "user");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()) {
			Screenshooter.takeScreenshot("ERROR", driver);
		}
		//driver.switchTo().window(tabs.get(1)).close();
		//driver.switchTo().window(tabs.get(0)).close();
		driver.close();
	}

}