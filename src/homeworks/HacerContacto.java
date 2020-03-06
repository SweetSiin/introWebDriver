package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HacerContacto {

	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {
		
		navegarPag("http://angelesunion.tk/");
		clickProducto("Vendajes"); // pasar nombre producto
		validarProducto("Vendajes"); // pasar el nombre de la misma manera
		clickContacto();
		DatosContacto d = new DatosContacto ("Andrea", "mensaje", "Recomendacion", "test@email.com");
		enviarForm(d);
		
		cerrarPagina();

	}



	private static void navegarPag(String navegaPag) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		driver.get(navegaPag);
		
	}



	private static void clickProducto(String productoLista) {
		
		WebElement clickProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src=\"imagenes/VENDAJES.jpg\"] ")));
		
		clickProducto.click();
		
	}
	
	private static void validarProducto(String titiloProduco) {
		
		WebElement imagenVendas = driver.findElement(By.xpath("//p[@align=\"center\"] "));
		
		if(imagenVendas.isDisplayed()// && carruselImgs.isDisplayed()
				)
			
			System.out.println("Imagen encontrada correctamente.");
		else {
			System.out.println("No se encontro el elemeto.");
			System.exit(-1);
		
		}
	}

	private static void clickContacto() {
		
		WebElement clickContacto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"CONTACTO.html\"]")));
		
		clickContacto.click();
		
	}

	private static void enviarForm(DatosContacto datos) {
		
		WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[1]/input")));
		nombre.sendKeys(datos.getNombre());
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[2]/input")));
		email.sendKeys(datos.getEmail());
		WebElement asunto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[3]/input")));
		asunto.sendKeys(datos.getAsunto());
		WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[4]/textarea")));
		mensaje.sendKeys(datos.getMensaje());
		
		WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[5]/input")));
		boton.click();
		
	}
	
	private static void cerrarPagina() {
		
		driver.close();
		driver.quit();
		
	}

}
