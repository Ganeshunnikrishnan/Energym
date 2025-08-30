package testbase;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class Baseclass {

	
	public static WebDriver driver;         
	
	 
	
	
    @BeforeClass
	
	
	
	public void setup() {

		if (driver == null) {
        
		driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));     
				driver.get("https://fitnessproject.pythonanywhere.com/");           
				driver.manage().window().maximize();                           
	}
		}
	
	public String randomName() {
        return "fit" + org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(5);
    }
	
	 @AfterClass
	    public void tearDown() {
	       if (driver != null) {
	           driver.quit();
	        }
	
}
}