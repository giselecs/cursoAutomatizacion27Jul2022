package Edit.EducacionIT27Jun2022;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio7 {
	String url = "https://demoqa.com/alerts";
	String firefoxDriverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

		driver = new FirefoxDriver();
		driver.navigate().to(url);  // driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertaNotificacion() {
		driver.findElement(By.id("alertButton")).click();
		
		// Tomamos control de la alerta para hacer click en aceptar
		Alert alert = driver.switchTo().alert();  // Cambia del modo activo a una instancia particular en este caso apra una alerta
		
		String texto = alert.getText();  // Obtiene el texto que tiene la alerta
		System.out.println(texto);
		
		alert.accept();  // Hacemos click en la opción OK (Aceptar)		
	}	
	
	@Test
	public void alertaEspera() {
		driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		
		// Agregar una espera de 10 segundo o hasta que la alerta aparezca
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
				
		driver.switchTo().alert().accept();  // Otra manera de traer el mensaje de alerta sin declarar el Alert
	}
	
	@Test
	public void alertaCancelar() {
		driver.findElement(By.cssSelector("#confirmButton")).click();;
		
		driver.switchTo().alert().dismiss();  // Hacemos click en Cancelar
	}
	
	@Test
	public void alertaTexto() {
		driver.findElement(By.id("promtButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		
		alerta.sendKeys("Clase de Automatización");  // Escribimos en el campo de texto de la alerta
		alerta.accept();		
	}
}

