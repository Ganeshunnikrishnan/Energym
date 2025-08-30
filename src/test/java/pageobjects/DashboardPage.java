package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;
//import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	 WebDriver driver;
	    WebDriverWait wait;
	    
	    public DashboardPage(WebDriver driver) {
	        this.driver = driver;
	       // PageFactory.initElements(driver, this);
	        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	    }
	    public void goToDashboard() {
	        driver.get("https://fitnessproject.pythonanywhere.com/dashboard/");
	        wait.until(ExpectedConditions.titleContains("Dashboard"));
	    }

	 
	    public boolean isGoalPresent(String goalName) {
	        try {
	            String xpath = "//li[contains(@class,'goal')]"
	                         + "[.//strong[normalize-space()='" + goalName + "']]";
	            WebElement goalRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	            return goalRow.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }


	    public void clickUpdateProgress(String goalName) {
	        try {
	        	String xpath = "//li[contains(@class,'goal') and .//strong[contains(normalize-space(),'" 
	                    + goalName + "')]]//a[normalize-space()='Update Progress']";

	            WebElement updateLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	            updateLink.click();
	            System.out.println("Clicked Update Progress link for goal: " + goalName);
	        } catch (Exception e) {
	            System.out.println("Failed to find or click Update Progress link for goal: " + goalName);
	            e.printStackTrace();
	        }
	    }

	    public void updateProgress(String progressValue) {
	        WebElement progressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("value")));
	        progressInput.clear();
	        progressInput.sendKeys(progressValue);

	        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[normalize-space()='Update Progress']")
	        ));
	        updateButton.click();
	    }

	    public boolean isUpdateSuccessful() {
	        try {
	            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[contains(text(),'Goal updated successfully')]")
	            ));
	            return successMsg.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	}