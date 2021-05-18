package helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Helpers {

	public static void sleepSeconds(int seconds) {
		try {Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void sleep(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
