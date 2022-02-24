import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addToCart {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//explicit wait: 1)WebDriverWait 2)FluentWait
		//WebDriverWait is only targetted elements.
		WebDriverWait w=new WebDriverWait(driver,5); // how many seconds the driver needs to wait
		int j=0;
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		/*w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));will not work
		 * 
		 * ExpectedConditions.presenceOfElementLocated is correct
		 * 
		 */
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			//convert array into array list for easy search
			
			List itemsNeededList=Arrays.asList(itemsNeeded);
			
			int j=0;
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				// never rely on the text, text changes
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				//driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeededList.size())
				{
					break;
				}
			}
			
		}
	}	
	

}


