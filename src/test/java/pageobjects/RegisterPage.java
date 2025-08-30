package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegisterPage {

	
WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	
	
	@FindBy(xpath="//input[@id='id_username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='id_email']")
	WebElement email;
	
	
	@FindBy(xpath="//input[@id='id_password1']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='id_password2']")
	WebElement confirmpass;
	
	@FindBy(xpath="//button[normalize-space()='Register']")
	WebElement regist;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginLink;
	
	
	public void setusername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setemail(String ename) {
		email.sendKeys(ename);
	}
	
	public void setpass(String pname) {
		password.sendKeys(pname);
		
	}
	
	
	public void setconfirm(String cname) {
		confirmpass.sendKeys(cname);
	}
	
	
	public void getresit() {
		regist.click();
		
		
	}
	
	
	public void clickLoginLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(loginLink)).click();
	}
	
	
}