package Paginas;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaLogin {
	// Elementos
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(name="passwd")
	WebElement txtContrasenia;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnLogin;
	
	WebDriver driver;		// Esto se agrega por la espera que tenemos más abajo

	// Constructor
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;			// Por agregar la espera, también tenemos que tomar la variable driver
	}
	
	// Acciones
	public void escribirEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void escribirContrasenia(String contrasenia) {
		txtContrasenia.sendKeys(contrasenia);
	}
	
	public void hacerClickEnElBotonLogin() {
		btnLogin.click();
	}
	
	// También se pueden colocar todos los elementos en una sola acción
	public void ingresarCredenciales(String email, String contrasenia) {
		txtEmail.sendKeys(email);
		txtContrasenia.sendKeys(contrasenia);
		btnLogin.click();
	}
	
}
