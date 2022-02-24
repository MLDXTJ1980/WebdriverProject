import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWait {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		// FluentWait is a class implementing Wait interface
		// timeout 30 seconds, will check every 3 sec if the web element found or not.
		// if not found, 
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class); 
		
		// fluentwait until webelement is found.
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		     if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
		     {
		       return driver.findElement(By.cssSelector("[id='finish'] h4"));  // element exist on the page, but not visiable. 
		     }
		     else return null;
		     }
		   });
		
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());  // exist but not displayed


	}

}
