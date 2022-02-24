import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class actionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.de/");
		Actions a=new Actions(driver);
		WebElement move=driver.findElement(By.cssSelector("a[id=\"nav-link-accountList\"]"));
		// hold the 'shift' key to input 'HELLO'
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		a.moveToElement(move).contextClick().build().perform(); // right click
		

	}

}
