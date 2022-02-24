
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestCase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// gecko driver
		System.setProperty("webdriver.ie.driver", "C:\\workspace\\iedriver_win64\\IEDriverServer.exe");
	
        WebDriver driver=new InternetExplorerDriver ();

        driver.get("http://google.com");
        
        System.out.println(driver.getTitle());
	}

}
