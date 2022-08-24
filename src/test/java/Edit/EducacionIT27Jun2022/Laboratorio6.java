package Edit.EducacionIT27Jun2022;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Laboratorio6 {
	String url = "http://automationpractice.com";  // colocar la ruta
	String driverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe"; // ruta donde está el driver gecko
	String dirEvidencias = "..\\EducacionIT27Jun2022\\Evidencias\\";
	String nombreDocumento = "Evidencias - AutomationPractice.docx";
	String nombreImg = "img.jpg";
	WebDriver driver;  // declaramos variable del driver, porque el codigo se va a dividir en varios metodos, y necesitamos que el driver sea global
	File screen;  // elemento del objeto del archivo java en particular
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();  //inicializamos la variable driver
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Opción Contáctanos", priority=1)
	public void irAContactanos() throws IOException {
		// Captura de Evidencia
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "01_PaginaPrincipal.jpg"));  // nos crea el archivo imagen como tal
		
		// Hacer click en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "02_EntrandoAContactUs.jpg"));
		
		//Completar Formulario
		Select list = new Select(driver.findElement(By.tagName("select")));
		list.selectByValue("2");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correomaria01@micorreo.com");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		// Campo para subir archivos
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\Users\\gisel\\eclipse-workspace\\EducacionIT27Jun2022\\a-brain-riding-a-rocketship.jpg");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Comentarios del Contacto");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "03_FormularioLleno.jpg"));
		
		driver.findElement(By.cssSelector("#submitMessage")).click();		
	
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "04_ResultadoObtenido.jpg"));
		
	}
	
	
	@Test(description="CP02 - Opción Contáctanos con Documento de Evidencias", priority=1)
	public void irAContactanosConDocumento() throws IOException, InvalidFormatException, InterruptedException {
		// Capturar pantalla en documento
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de Evidencias - AutomationPractice", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 1 - Página Principal");
				
		// Hacer click en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 2 - Luego de acceder a ContactUs");
		
		//Completar Formulario
		Select list = new Select(driver.findElement(By.tagName("select")));
		list.selectByValue("2");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("correomaria01@micorreo.com");
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		// Campo para subir archivos
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\Users\\gisel\\eclipse-workspace\\EducacionIT27Jun2022\\a-brain-riding-a-rocketship.jpg");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Comentarios del Contacto");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 3 - Luego de completar el formulario");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();		
	
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + nombreImg, dirEvidencias + nombreDocumento, "Paso 4 - Luego de hacer click en enviar");
		
	}
}
