package Edit.EducacionIT27Jun2022;		// Nombre del paquete al cual pertenece la clase

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Clase principal
public class Laboratorio2 {
	// Variables
	String url = "http://automationpractice.com";
	String chromeDriverPath = "..\\EducacionIT27Jun2022\\Drivers\\chromedriver.exe";
	String geckoDriverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe";
	
	//Métodos de Prueba
	@Test			// Es para indicar que vamos a hacer una prueba
	public void buscarPalabraEnChrome() {
		// Paso 1: Indicar dónde está el driver.exe
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Paso 2: Abrir el navegador Chrome en la URL que voy a probar
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		// Paso 3: Escribir la palabra que quiero buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Simular que presiono la tecla ENTER de mi teclado
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador (importante si vamos a correr muchas pruebas)
		
	}
	
	@Test			// Es para indicar que vamos a hacer una prueba
	public void buscarPalabraEnFirefox() {
		// Paso 1: Indicar dónde está el driver.exe
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		
		// Paso 2: Abrir el navegador Firefox en la URL que voy a probar
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// Paso 3: Escribir la palabra que quiero buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Simular que presiono la tecla ENTER de mi teclado
		txtBuscador.sendKeys(Keys.ENTER);
		
		System.out.println("URL: " + driver.getCurrentUrl());
		System.out.println("Título de la Página: " + driver.getTitle());
		
		// Paso 5: Cerrar el navegador
		
	}
}
