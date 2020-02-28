package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class riotMerch {

	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		
		navegarUrl ("https://merch.riotgames.com/en_US/");
		
		validarPagPrincipal ();
		
		buscarProducto ("KDA");
		
		Thread.sleep(4000);
		
		listaProductos ();
		
		validarBusqueda ();
		
		seleccionarProducto ();
		
		verificarPagProducto ();
		
		agregarProductoCarrito ();
		
		validarProductoCarrito ();	

		cerrarPagina ();
		

	}

//	private static void enviarDatos(String productoKda) {
//	 
//		WebElement productoRiotName; //kda
//		
//		productoRiotName = driver.findElement(By.xpath("//*[@id=\"riot-merch-search-bar-wrapper\"]/div/input"));
//		
//		productoRiotName.sendKeys(productoKda);
//		
//		
//	}

	private static void buscarProducto(String productoKda) {
		
		WebElement productoRiotFoco ; //click
	//	WebElement productoRiotName; //kda
		//WebElement botonLogin; //data-testid="royal_login_button"
		
		productoRiotFoco = driver.findElement(By.id("riot-games-merch-search-container"));
	//	productoRiotName = driver.findElement(By.xpath("//input[@class=\"css-1rzx0hf\"]"));
		//botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		productoRiotFoco.click();
		WebElement barraBusqueda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("riot-merch-search-bar-wrapper")));
		barraBusqueda.click();
		WebElement inp = barraBusqueda.findElement(By.xpath(".//input"));
		inp.sendKeys(productoKda);
		
	}	
	

	private static void navegarUrl(String navegaUrl) {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		driver.get(navegaUrl);
		
	}

	private static void validarPagPrincipal() {

		WebElement carruselImg = driver.findElement(By.xpath("//div[@class=\"slick-track\"]"));
		//WebElement carruselImgs = driver.findElement(By.xpath("//div[@clas=\"slick-track\"]"));
		
		if(carruselImg.isDisplayed()// && carruselImgs.isDisplayed()
				)
			
			System.out.println("Carrusel de imagenes encontrado correctamente.");
		else {
			System.out.println("No se encontro el elemeto Carrusel de imagenes.");
			System.exit(-1);
		}
		
	}


	private static void validarBusqueda() {
		
		WebElement ventanaBuscador = driver.findElement(By.xpath("//div[@class= \"css-1rcan5s\"]"));
		
		if(ventanaBuscador.isDisplayed())
			System.out.println("El elemento se encontro correctamente.");
		else {
			System.out.println("No se encontro el elemeto.");
			System.exit(-1);
		}
		
	}

	private static void listaProductos () {
		
		WebElement clickLinkLista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/en_US/search?q=kda\"]")));
		
		clickLinkLista.click();
	}
	
	private static void seleccionarProducto() {
		
		WebElement clickProducto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/div[3]/div")));
		
		clickProducto.click();
	}

	private static void verificarPagProducto() {
		
		
		
	}

	private static void agregarProductoCarrito() {
		// TODO Auto-generated method stub
		
	}

	private static void validarProductoCarrito() {
		// TODO Auto-generated method stub
		
	}

	
	private static void cerrarPagina() {
		
		driver.close();
		driver.quit();
		
	}
}
