package tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.Helpers;
import helpers.Screenshooter;

public class CondicionesComunes {
	protected WebDriver driver;
	ArrayList<String> tabs;
	@BeforeMethod
	public void setUp() {
		String driverByOS="";
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").equals("Windows 10")) {
			driverByOS = "Drivers/chromedriver.exe";
		} else {driverByOS = "Drivers/chromedriver";}
		
		System.setProperty("webdriver.chrome.driver",driverByOS);
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
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		String ok = "OK", error = "ERROR";
		System.out.println("El test " + result.getMethod().getDescription() + "resulto: "+ (result.getStatus()==1?ok:error));
		if(!result.isSuccess()) {
			Screenshooter.takeScreenshot("ERROR", driver);
		}
		//driver.switchTo().window(tabs.get(1)).close();
		//driver.switchTo().window(tabs.get(0)).close();
		driver.close();
	}
}
