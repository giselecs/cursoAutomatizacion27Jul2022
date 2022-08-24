package Edit.EducacionIT27Jun2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio4 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String firefoxDriverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe"; //ubicación del driver
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath); // dónde está nuestro driver
		
		/* FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--incognito");  // Abrir el navegador en modo incógnito
		*/
		
		WebDriver driver = new FirefoxDriver(/*options*/); // creamos el elemento que representa el navegador
		driver.navigate().to(url);  // abre el navegador en la página indicada
		driver.manage().window().maximize();
		
		// Primera Parte - Escribo el correo y hago click en el botón
		driver.findElement(By.id("email_create")).sendKeys("correomaria" + Math.random() + "@correo.com");
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Espera Explícita con un tiempo máximo y una condición de salida - Transición de página
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		// Segunda Parte - Formulario - Información Personal
		driver.findElement(By.cssSelector("#id_gender1")).click();  // Radio Button "Title"
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("María");  // First Name
		driver.findElement(By.id("customer_lastname")).sendKeys("López");  // Last Name
		driver.findElement(By.name("passwd")).sendKeys("1a2s3d");  // Password
		
		Select days = new Select(driver.findElement(By.cssSelector("#days")));  // Lista de days
		days.selectByValue("18");
		
		Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));  // Lista de months
		months.selectByVisibleText("June ");
		
		Select years = new Select(driver.findElement(By.id("years")));  // Lista de years
		years.selectByIndex(30);
		
		driver.findElement(By.name("newsletter")).click();  // check Newsletter
		
		WebElement chkOffers = driver.findElement(By.cssSelector("#optin"));  // check Offers
		chkOffers.click();
		
		// Tercera Parte - Formulario - Dirección
		
		driver.findElement(By.cssSelector("#company")).sendKeys("Empresa ABC S.A.");  // Company
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("MiCalle 1234 7D");  // Address
		driver.findElement(By.id("address2")).sendKeys("Entre calles 1 y 2");  // Address 2
		driver.findElement(By.name("city")).sendKeys("Rosario");  // City
		
		Select states = new Select(driver.findElement(By.cssSelector("#id_state")));  // State
		states.selectByVisibleText("California");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12563");  // Zip Code
		
		// Country tiene una sola opción de select, por lo que no lo vamos a hacer, no es necesario
		
		driver.findElement(By.id("other")).sendKeys("Comentario del Usuaeio que es está registrando");  // Additional information
		driver.findElement(By.name("phone")).sendKeys("5491158792230");  // Home Phone
		driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("5491136326988");  // Mobile Phone
		
		// Alias
		WebElement txtAlias = driver.findElement(By.xpath("//input[@id='alias']"));  // Alias
		txtAlias.clear();
		txtAlias.sendKeys("Casa");
		
		/*
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Casa");
		*/
		
		driver.findElement(By.id("submitAccount")).click();  // Button Register
		
	}
			

}
