package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class riotMerch1 {

static WebDriver driver;
static WebDriverWait wait;
	
public static void main(String[] args) 
	throws InterruptedException {
		navegarUrl ("https://merch.riotgames.com/en_US/");
		
		validarPagPrincipal ();
		
		buscarColeccionables ();
		
		validarColeccionables ();
		
		seleccionarProducto ();
		
		verificarPagProducto ();
		
		agregarProductoCarrito ();
		
		Thread.sleep(4000);
			
		clickCarrito ();
		
		validarProductoCarrito ();	

		cerrarPagina ();
		
	
	}

private static void navegarUrl(String navegarPag) {
	
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15,  TimeUnit.SECONDS);
	driver.get(navegarPag);
	
}

private static void validarPagPrincipal() {
	
	WebElement carruselImg = driver.findElement(By.xpath("//div[@class=\"slick-track\"]"));
	
	if(carruselImg.isDisplayed()// && carruselImgs.isDisplayed()
			)
		
		System.out.println("Carrusel de imagenes encontrado correctamente.");
	else {
		System.out.println("No se encontro el elemeto Carrusel de imagenes.");
		System.exit(-1);
	}
}

private static void buscarColeccionables() {
	
	WebElement pestaña = driver.findElement(By.xpath("//a[@data-riotbar-link-id=\"collectibles\"]"));
	WebElement coleccionables = driver.findElement(By.xpath("//a[@href=\"/en_US/collection/figures\"]"));
	
	pestaña.click();
	pestaña.click();
	coleccionables.click();
}

private static void validarColeccionables() {

	WebElement tituloFiguras = driver.findElement(By.xpath("//div[@class=\"css-tqs2y\"]"));
	WebElement cuadriculaFiguras = driver.findElement(By.xpath("//div[@class=\"css-1t66nmp\"]"));
	WebElement botonMasFiguras = driver.findElement(By.xpath("//button[@class=\"css-pghaw9\"]"));
	
	if(tituloFiguras.isDisplayed() && cuadriculaFiguras.isDisplayed() && botonMasFiguras.isDisplayed())
		
		System.out.println("Se encontraron los elementos requeridos.");
	else {
		System.out.println("No se encontraron los elementos.");
		System.exit(-1);
	
   }
}

private static void seleccionarProducto() {
	
	WebElement imagenProducto = driver.findElement(By.xpath("//a[@href=\"/en_US/product/k-da-team-minis\"]"));
	
	imagenProducto.click();
	
}

private static void verificarPagProducto() {
	
	WebElement listaImg = driver.findElement(By.xpath("//div[@class=\"slick-list\"]"));
	WebElement descripcionFiguas = driver.findElement(By.xpath("//div[@class=\"css-18hfe0s\"]"));
	WebElement botonAgregarFiguras = driver.findElement(By.xpath("//button[@class=\"add-to-cart-btn css-172lhsg\"]"));
	
	if(listaImg.isDisplayed() && descripcionFiguas.isDisplayed() && botonAgregarFiguras.isDisplayed())
		
		System.out.println("Se encontraron los elementos requeridos de la pagina.");
	else {
		System.out.println("No se encontraron los elementos.");
		System.exit(-1);
	
   }
	
}

private static void agregarProductoCarrito() {

	//WebElement agregarProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"add-to-cart-btn css-172lhsg\"]")));
	WebElement agregarProducto = driver.findElement(By.xpath("//button[@class=\"add-to-cart-btn css-172lhsg\"]"));
	
	agregarProducto.click();
	//agregarProducto.click();	
	
}

private static void clickCarrito() {
	
	//try {
	
	WebElement mochila = driver.findElement(By.id("riot-games-merch-cart-container"));
	//barraBusqueda.getSize()>0;
	//WebElement mochila = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"merch-top-bar-count css-ykqlp4\"]")));
	mochila.click();
	
	//}catch (Exception a)
	//	{
		
	//	System.out.println(" Error al cargar los datos.");
	
	//}
	
//	finally
//	{
		
	//	System.out.println(" No se puede continuar la ejecucion.");
		
		//driver.close();
		//driver.quit();
		
	//}
	//barraBusqueda.click();

//WebElement mochila = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("riot-games-merch-cart-container")));
    
    //WebElement mochila = driver.findElement(By.id("riot-games-merch-cart-container"));
    
   // WebElement mochila = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("riot-games-merch-cart-container")));
    
    //mochila.size()>0;
   // mochila.click();
    //mochila.click();
    
}


private static void validarProductoCarrito() {
	
	WebElement textLinkRemove = driver.findElement(By.xpath("//span[@class=\"css-1fagh72\"]"));
	WebElement totalText = driver.findElement(By.xpath("//div[@class=\"css-9vskfw\"]"));
	WebElement botonProceder = driver.findElement(By.xpath("//button[@class=\"css-pghaw9\"]"));
	
	if(textLinkRemove.isDisplayed() && totalText.isDisplayed() && botonProceder.isDisplayed())
		
		System.out.println("Se encontraron los elementos requeridos para la pagina.");
	else {
		System.out.println("No se encontraron los elementos.");
		System.exit(-1);
	}
	
}

private static void cerrarPagina() {
	
	driver.close();
	driver.quit();
	
 }
}
