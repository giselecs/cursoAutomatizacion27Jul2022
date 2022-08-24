package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaHome {
	// Elementos de la Pagina que voy a utilizar
	@FindBy(partialLinkText="Sign")
	WebElement lnkSignIn;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
		
	// Constructor: Es lo que permite utilizar estos elementos y sus acciones
	// Lo que hace es iniciar los elementos para su uso
	// No lleva void porque no es un método, es un constructor
	public PaginaHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos de la página que voy a utilizar
	public void hacerClickEnSignIn() {
		lnkSignIn.click();
	}
	
	public void hacerClickEnContactUs() {
		lnkContactUs.click();
	}
}
