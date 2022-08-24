package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.PaginaContactUs;
import Paginas.PaginaHome;
import Paginas.PaginaLogin;

public class Laboratorio7a {
	String url = "http://automationpractice.com";
	String firefoxDriverPath = "..\\EducacionIT27Jun2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() { 
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();		
	}
	
	@Test
	public void login() {
		// Click en Sign In
		PaginaHome home = new PaginaHome(driver);
		home.hacerClickEnSignIn();
		
		// Completar las credenciales para iniciar sesión
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo01@gmail.com");
		login.escribirContrasenia("1a2s3d");
		login.hacerClickEnElBotonLogin();
		
	}
	
	@Test
	public void irAContactanos() {
		PaginaHome home = new PaginaHome(driver);
		home.hacerClickEnContactUs();
		
		PaginaContactUs contacto = new PaginaContactUs(driver);
		contacto.seleccionarSubject("Webmaster");
		contacto.escribirEmail("correo02@gmail.com");
		contacto.escribirOrder("7D");
		contacto.adjuntarArchivo("C:\\Users\\gisel\\eclipse-workspace\\EducacionIT27Jun2022\\a-brain-riding-a-rocketship.jpg");
		contacto.escribirMensaje("Mensaje de Contacto");
		contacto.hacerClickEnElBotonSend();
	}
}
