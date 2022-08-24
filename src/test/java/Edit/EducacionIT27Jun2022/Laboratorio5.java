package Edit.EducacionIT27Jun2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5 {
	String url = "http://automationpractice.com";  // colocar la ruta
	String driverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe"; // ruta donde está el driver gecko
	WebDriver driver;  // declaramos variable del driver, porque el codigo se va a dividir en varios metodos, y necesitamos que el driver sea global
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();  //inicializamos la variable driver
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Opción Contáctanos", priority=1)
	public void irAContactanos() {
		
		
		// Hacer click en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		//Completar Formulario
		Select list = new Select(driver.findElement(By.tagName("select")));
		list.selectByValue("2");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correomaria01@micorreo.com");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		// Campo para subir archivos
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\Users\\gisel\\eclipse-workspace\\EducacionIT27Jun2022\\a-brain-riding-a-rocketship.jpg");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Comentarios del Contacto");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();		
	}
	
	@Test(description="CP02 - Buscar Palabra", priority=2)
	public void buscarPalabra() {
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");;
		driver.findElement(By.name("submit_search")).click();
		
		// Compruebe que después de hacer click, el título cambia a Search - My Store
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle();
		
		Assert.assertEquals(tituloActual, tituloEsperado);
	
		/* validación de elementos
		WebElement elementEsperado = null;
		
		try {
			elementEsperado = driver.findElement(By.id("myID"));
		} catch (NoSuchElementException e) {
			// código a ejecutar en caso que el try dé la excepeción
		}
		
		Assert.assertNotNull(elementEsperado);
		*/
	}
	
}
