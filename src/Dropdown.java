import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdown { 
	// dynamic dropdown
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
        driver.get("http://spicejet.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
       // Xpath for the selected city: //a[@value='MAA'] ---> for each city can u find two elements(from and to)
       // From
        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();        
        driver.findElement(By.cssSelector("a[value='DEL']")).click();
        System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).getAttribute("value"));

       // To
       driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();     
       //driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();   
       driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
       System.out.println( driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("value"));

       // Calender
       // .ui-state-default ui-state-highlight ui-state-active locator should be connect with .
       driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
       
       //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
       System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
       driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
       System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
       if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
       {
    	   System.out.println("its disabled");
    	   Assert.assertTrue(true);
       }
       else
       {
    	   Assert.assertTrue(false);
       }
       //driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
       driver.findElement(By.id("divpaxinfo")).click();
       

       Thread.sleep(1000);

       // Selection of Adults

       //WebElement Adults = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));
       WebElement Adults = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
       

       Select adultsdrp = new Select(Adults);

       adultsdrp.selectByValue("2");

       // Selection of Childs

       WebElement childs = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));

       Select childsdrp = new Select(childs);

       childsdrp.selectByValue("2");

       driver.findElement(By.id("divpaxinfo")).click();

       System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
       
       // select CURRENCY
       WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
       Select dropdown = new Select(staticDropdown);
       dropdown.selectByValue("INR");
       
       // click search
       driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}


}
