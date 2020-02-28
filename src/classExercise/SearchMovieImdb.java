package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchMovieImdb {
	
	static WebDriver driver;

	public static void main(String[] args) {
		navegarPagina("https://imdb.com");
		verificarPaginaPrincipal();
		ingresarPelicula("Joker");
		verificarOpciones();
 	    realizarBusqueda();
 	    verificarListaPeliculas("Joker");
 	    cerrarVentana();
	}

	private static void cerrarVentana() {
		driver.close();
		driver.quit();
	}

	private static void navegarPagina(String string) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.get("https://imdb.com");
	}

	private static void verificarPaginaPrincipal() {
		//listar todos los elementos a buscar
		WebElement logoimdb = driver.findElement(By.id("home_img_holder"));
		WebElement serchBox = driver.findElement(By.name("q"));
		WebElement serchButton = driver.findElement(By.id("suggestion-search-button"));
		WebElement singInLink = driver.findElement(By.xpath("//a[@href='/registration/signin?u=/']"));
		
		if(logoimdb.isDisplayed() && serchBox.isDisplayed() && serchButton.isDisplayed() && singInLink.isDisplayed() )//agregar todos los otros elementos a verificar y completar el if
			System.out.println("Todos los elementos se encontraron correctamente.");
		else {
			System.out.println("No se encontro algun elemeto.");
			System.exit(-1);
		}
	}

	private static void ingresarPelicula(String nombrePelicula) {
		WebElement searchBox = driver.findElement(By.name("q"));
		//WebElement searchButton = driver.findElement(By.id("suggestion-search-button"));
		
		searchBox.clear();
		searchBox.sendKeys(nombrePelicula);
		//searchButton.click();
	}

	private static void verificarOpciones() {
		WebElement movieSuggestionElemen = driver.findElement(By.xpath("//div[contains(@class, 'imdb-header__search-menu')]"));
		
		if(movieSuggestionElemen.isDisplayed())
			System.out.println("El elemento se encontro correctamente.");
		else {
			System.out.println("No se encontro el elemeto.");
			System.exit(-1);
		}
	}


	private static void realizarBusqueda() {
		// TODO Auto-generated method stub
		WebElement searchButton = driver.findElement(By.id("suggestion-search-button"));
		searchButton.click();
	}

	private static void verificarListaPeliculas(String string) {
		WebElement movieSuggestionElemen = driver.findElement(By.id("suggestion-search-button"));
		WebElement searchResultPage = driver.findElement(By.xpath("//h1[@class='findHeader']"));
		WebElement movieLink = driver.findElement(By.xpath("//a[@href='/title/tt7286456/?ref_=fn_al_tt_1']"));
		
		if(movieSuggestionElemen.isDisplayed() && searchResultPage.isDisplayed() && movieLink.isDisplayed())
			System.out.println("El elemento se encontro correctamente.");
		else {
			System.out.println("No se encontro el elemeto.");
			System.exit(-1);
		}
		
	}
}
