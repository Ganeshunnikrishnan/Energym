package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GoalPage {

WebDriver driver;
WebDriverWait wait;


	public GoalPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	@FindBy(xpath = "//input[@id='goal_name']")
	WebElement goal;
	
	@FindBy(xpath = "//input[@id='target_value']")
	WebElement target;
	
	@FindBy(xpath="//button[normalize-space()='Set Goal']")
	WebElement goallog;
	
	
	
	 
	public void enterGoalName(String gname) {
		wait.until(ExpectedConditions.visibilityOf(goal));
		goal.clear();
		goal.sendKeys(gname);
	}
	
	public void enterTargetValue(String tarname) {
		 wait.until(ExpectedConditions.visibilityOf(target));
	     target.clear();
		target.sendKeys(tarname);
	}
	
	public void clickgoalset() {
		 wait.until(ExpectedConditions.elementToBeClickable(goallog)).click();
	}
	
	   public void setGoal(String goalName, String targetValue) {
	        enterGoalName(goalName);
	        enterTargetValue(targetValue);
	        clickgoalset();
	    }
	
	
}
