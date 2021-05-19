package tests;

import org.testng.annotations.Test;

import helpers.WebDriverManager;
import pages.PageLogin;
import pages.PageReservation;

public class Reservas extends CondicionesComunes{
	@Test(description = "Redimensionar y setear reserva",enabled = true)
	public void pruebaTres() {
		WebDriverManager.setWindowSize(driver, 800, 600);
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.flights();
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("Frankfurt");		
	}

}
