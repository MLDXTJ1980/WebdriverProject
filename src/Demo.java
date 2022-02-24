import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver_win32\\chromedriver.exe");
	
        WebDriver driver=new ChromeDriver();

        driver.get("http://google.com");
        
        System.out.println(driver.getTitle());
        //System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
        driver.get("http://yahoo.com");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.close();
        driver.quit();
        //driver.findElement(By.id("email")).sendKeys("email input");
        
	}

}
