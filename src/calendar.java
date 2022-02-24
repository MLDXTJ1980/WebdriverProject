import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendar {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C:\\workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("ez-accept-all")).click();
		// Apr.23
		//w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='travel_date']")));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='travel_date']")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}
			
		List<WebElement> dates=driver.findElements(By.className("day"));
		int count=dates.size();
		for(int i=0;i<count;i++)
		{
			String text=dates.get(i).getText();
			if(text.equalsIgnoreCase("23"))
			{
				dates.get(i).click();
				break;
			}
		}

	}

}
