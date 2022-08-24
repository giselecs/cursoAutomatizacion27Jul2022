package Edit.EducacionIT27Jun2022;		// En qué paquete está el archivo

import org.testng.annotations.Test;		// Librerías que se necesitan para ejecutar el archivo

/**
 * Unit test for simple App.
 */
public class AppTest 		// La clase se debe llamar igual a cómo se llama el archivo
{
	String frase = "Mi Primera Clase de Automatización";
    int numero = 35;
	
	/**
     * Rigorous Test :-)
     */
    @Test				//Significa que lo que viene es una prueba
    public void imprimirEnConsola()			//Es un método (conjunto de instrucciones)
    {
    	//Instrucción para imprimir algo en la consola
        System.out.println(frase);
    }
}
