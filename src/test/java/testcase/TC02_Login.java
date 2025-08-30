package testcase;

import org.testng.annotations.Test;
import pageobjects.*;
import testbase.Baseclass;
import org.testng.Assert;
import utils.TestData;
import org.apache.logging.log4j.Logger;
import utils.LoggerManager;

public class TC02_Login extends Baseclass {
	
	Logger logger = LoggerManager.getLogger(this.getClass());
	
    @Test( priority = 2)
    		
    		
    public void testLogin() {
    	
    	

    	  logger.info(" Starting login test...");
          logger.info("Using registered username: " + TestData.registeredUsername);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.entername(TestData.registeredUsername);
        loginPage.enterpassword(TestData.registeredPassword);
        loginPage.clicklogin();
        logger.info("Submitted login form.");
        
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL after login: " + currentUrl);
        
      //  System.out.println("Log: " + TestData.registeredUsername);
        //System.out.println("pass: "+ TestData.registeredPassword );
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
        logger.info(" Login successful. Redirected to dashboard.");
    }
}
