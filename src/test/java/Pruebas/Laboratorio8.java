package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Paginas.PaginaHome;
import Paginas.PaginaLogin;
import Utilidades.DatosExcel;

public class Laboratorio8 {
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
	
	@Test(dataProvider="Datos Login Excel")		// Enlazamos el @Test con @DataProvider
	public void login(String email, String password) {	// Agregamos nuevas variables, y la cantidad debe coincidir con el número de filas del arreglo Object
		// Click en Sign In
		PaginaHome home = new PaginaHome(driver);
		home.hacerClickEnSignIn();
		
		// Completar las credenciales para iniciar sesión
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirContrasenia(password);
		login.hacerClickEnElBotonLogin();		
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT27Jun2022\\Datos\\ExcelDataProvider25Jul2022.xlsx", "Hoja1");
	}
	
	
	@DataProvider(name="Datos Login")		// Nos pide un parámetro, ponemos el nombre del método (name)
	public Object[][] obtenerDatos() {			// Cuando no coloco el void sino "algo", significa que ese "algo" se tiene que devolver
		Object[][] datos= new Object[3][2];		// Voy a tener 3 set de datos para probar el login
		
		datos[0][0] = "abc@gmail.com";	// Correo
		datos[0][1] = "123456";	// Contraseña
		
		datos[1][0] = "def@gmail.com";	// Correo
		datos[1][1] = "789123";	// Contraseña
		
		datos[2][0] = "ghi@gmail.com";	// Correo
		datos[2][1] = "456789";	// Contraseña
		
		return datos;
	}
}
