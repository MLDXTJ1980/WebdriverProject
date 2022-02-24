
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		String downloadPath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver_win32\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		//1）更改chrome驱动程序路径 2）将downloadFilepath更改为所需的所需位置
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
				
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();
		Thread.sleep(3000);
		//Runtime类是单实例的，每个Java应用程序都有一个该类的实例，它允许应用程序和运行应用程序的环境进行交互。可使用getRuntime方法获取该类的实例。
		//Runtime.getRuntime().exec("C:\\Users\\Shanshan Zhao\\eclipse-workspace\\check\\fileUpload.exe"); //There should be no space in the path
		Runtime.getRuntime().exec("C:\\workspace\\LL\\fileUpload.exe"); 
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		
		driver.findElement(By.linkText("Download Now")).click();
		Thread.sleep(5000);  // can not use Selenium WebDriverWait, because it can only be used in web path
		File f=new File(downloadPath+"/1.jpg");
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			//f.delete();
			//System.out.println("file deleted");
			if(f.delete()) {System.out.println("file deleted");}
			
		}
		

	}

}
