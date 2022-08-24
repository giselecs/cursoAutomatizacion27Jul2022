package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio9 {
	String url = "https://demo.guru99.com/test/table.html";
	String driverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@Test
	public void leerValoresTabla() {
		System.out.println("Valor de Fila 1, Columna 3: " + driver.findElement(By.xpath("//td[contains(text(),'3')]")).getText());
		System.out.println("Valor de Fila 3, Columna 2: " + driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText());
		System.out.println("Valor de Fila 4, Columna 2: " + driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
	}
	
	@AfterSuite
	public void cerrar() {
		driver.close();
	}
}
