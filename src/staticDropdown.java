import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class staticDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver_win64\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        
       // dropdown with select tag - static
       WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
       Select dropdown = new Select(staticDropdown);
       dropdown.selectByIndex(3);
       System.out.println(dropdown.getFirstSelectedOption().getText());
       dropdown.selectByVisibleText("AED");
       System.out.println(dropdown.getFirstSelectedOption().getText());
       dropdown.selectByValue("INR");
       System.out.println(dropdown.getFirstSelectedOption().getText());
       Assert.assertEquals(10, 10);
	}

}
