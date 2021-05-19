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

public class Login extends CondicionesComunes{	
	@Test(description = "Login Correcto")
	public void pruebaUno() {
		//WebDriverManager.setWindowSize(driver, "fullscreen");
		//driver.switchTo().window(tabs.get(1)).navigate().to("https://www.infobae.com/");
		//driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		PageLogon pageLogon = new PageLogon(driver);
		pageLogin.login("user", "user");
		pageLogon.assertLogonPage();				
	}
	
	@Test(description = "Maximizar y abrir pagina de reservas",enabled = false)
	public void pruebaDos() {
		WebDriverManager.setWindowSize(driver, "maximized");
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.flights();
		pageReservation.assertPage();				
	}
		
	@Test(description="Verificar el array tagname y el logueo con campos",enabled = false)
	public void pruebaCantidadDeCampos() {		
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields();
		pageLogin.fields_login("user", "user");
	}
	
	@Test(description = "Obtener el titulo de la pagina y utilizarlo",enabled = false)
	public void pruebaTituloEnUsuario() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.putTitleInUserField();
	}

}