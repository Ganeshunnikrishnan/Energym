package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

WebDriver driver;
WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	
	
	
	@FindBy(xpath="//input[@id='id_username']")
      WebElement usname;
	
	@FindBy(xpath="//input[@id='id_password']")
	WebElement paname;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login;
	
	
	
	
	public void entername(String fname) {
		wait.until(ExpectedConditions.visibilityOf(usname)).sendKeys(fname);
	}
	
	
	public void enterpassword(String pasname) {
		wait.until(ExpectedConditions.visibilityOf(paname)).sendKeys(pasname);
	}
	
	public void clicklogin() {
		 wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	}
	
	 public boolean isLoginSuccessful() {
	        return driver.getPageSource().contains("Set Goal") || driver.getCurrentUrl().contains("/dashboard");
	    }
	
	
}
