package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class HomePage {

	
	WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;
    
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginLink;

    @FindBy(xpath = "//a[contains(@href, 'set_goal')]")
    WebElement setGoalLink;

    
    
    //driver.findElement(By.xpath("//a[normalize-space()='Set Goal']"))
    
    
    
    @FindBy(xpath = "//a[normalize-space()='Leaderboard']")
    WebElement leaderboardLink;
    
    public void clickRegister() {
        registerLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void clickSetGoal() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(setGoalLink));
    	    setGoalLink.click();
    	    
    	
    }

    public void clickLeaderboard() {
        leaderboardLink.click();
    }
    
    
}
