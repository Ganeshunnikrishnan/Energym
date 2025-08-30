package testcase;

//import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pageobjects.*;
import testbase.Baseclass;
import org.testng.Assert;
import utils.TestData;
import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;
import utils.LoggerManager;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;

public class TC01_Register extends Baseclass {

	
	 Logger logger = LoggerManager.getLogger(this.getClass());
	
    @Test(priority = 1)
    public void testRegistration() throws InterruptedException {
    	
    	 logger.info("Navigating to registration page...");
        HomePage home = new HomePage(driver);
        home.clickRegister();

        RegisterPage regPage = new RegisterPage(driver);
        
        String username = randomName();
        String randomEmail = username + "@gmail.com";
        String password = "ganu@1234";
        
        logger.info("Filling out registration form with username: " + username);
        
        regPage.setusername(username);
        regPage.setemail(randomEmail);
        regPage.setpass(password);
        regPage.setconfirm(password);
        regPage.getresit();

        TestData.registeredUsername = username;
        TestData.registeredPassword = password;
     
        Thread.sleep(2000); // wait for redirect
        
        
        String currentUrl = driver.getCurrentUrl();
        String pageText = driver.findElement(By.tagName("body")).getText();

        
       // System.out.println("Current URL after registration: " + currentUrl);
       // System.out.println("PAGE TEXT AFTER REGISTRATION:\n" + pageText);
        
        
        logger.info("Current URL after registration: " + currentUrl);
        logger.debug("Page text after registration:\n" + pageText);
      
        Assert.assertTrue(driver.getCurrentUrl().contains("/login/"), "Expected redirect to login after registration.");
        //System.out.println("Registered with Username: " + username);
        logger.info(" Registration successful. Username: " + username);
    }
    
}
