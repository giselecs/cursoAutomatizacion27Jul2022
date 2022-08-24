package Paginas;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaContactUs {
	// Elementos
	@FindBy(name="id_contact")
	WebElement selSubject;
	
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(id="id_order")
	WebElement txtOrder;
	
	@FindBy(xpath="//input[@id='fileUpload']")
	WebElement filAttach;
	
	@FindBy(name="message")
	WebElement txtMessage;
	
	@FindBy(id="submitMessage")
	WebElement btnSend;
	
	WebDriver driver;		// Por la espera
	
	// Constructor
	public PaginaContactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Acciones	
	public void seleccionarSubject(String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(selSubject));
		
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(visibleText);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrder(String order) {
		txtOrder.sendKeys(order);
	}
	
	public void adjuntarArchivo(String rutaArchivo) {
		filAttach.sendKeys(rutaArchivo);
	}
	
	public void escribirMensaje(String mensaje) {
		txtMessage.sendKeys(mensaje);
	}
	
	public void hacerClickEnElBotonSend() {
		btnSend.click();
	}
}
