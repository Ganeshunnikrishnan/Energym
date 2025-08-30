package testcase;


import org.testng.annotations.Test;
import pageobjects.GoalPage;
import pageobjects.HomePage;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;
import testbase.Baseclass;
//import org.openqa.selenium.By;
import utils.TestData; 
//import org.openqa.selenium.support.ui.ExpectedConditions;

//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;
import org.apache.logging.log4j.Logger;
import utils.LoggerManager;
//import org.openqa.selenium.By;

public class TC_03Goal  extends Baseclass {
	
	 Logger logger = LoggerManager.getLogger(this.getClass());
	
	 @Test(priority = 3)
	    public void testSetGoalAndVerifyDashboard() {

		  logger.info("Starting TC_03Goal test...");
		 
		 
		  System.out.println(" Starting TC_03Goal test...");
		  LoginPage loginPage = new LoginPage(driver);
		  HomePage homePage = new HomePage(driver);
	       
		 
		  
		  //  Login if not already logged in
		  
		  if (!driver.getCurrentUrl().contains("/dashboard")) {
	           // System.out.println(" Logging in with: " + TestData.registeredUsername);
			  logger.info("Logging in with: " + TestData.registeredUsername);
			  
			  
	            loginPage.entername(TestData.registeredUsername);
	            loginPage.enterpassword(TestData.registeredPassword);    // take the value from testdata login tc02
	            loginPage.clicklogin();
	            
	        if (!loginPage.isLoginSuccessful()) {
	           // System.out.println("Login failed — cannot proceed to Set Goal");    // if dashboard okay if not fail
	        	   logger.warn("Login failed — cannot proceed to Set Goal.");
	        	return;
	        }
	        
	        
	       // System.out.println("Login successful.");
	        logger.info(" Login successful.");
	        
	        }

	        // Navigate to Set Goal page
	        homePage.clickSetGoal();
	      //  System.out.println("Navigated to Set Goal page: " + driver.getCurrentUrl());     //printing url
	        logger.info(" Navigated to Set Goal page: " + driver.getCurrentUrl());
	        
	        //  Enter Goal and Target
	        GoalPage goalPage = new GoalPage(driver);
	        String goalName = "Run " + (int) (Math.random() * 100) + "km";
	        String targetValue = "30";
	        String progressValue = "10";

	        TestData.goalName = goalName;
	        TestData.progressValue = progressValue;
	        
	        logger.info(" Setting goal: " + goalName + ", Target: " + targetValue);
	        goalPage.enterGoalName(goalName);
	        goalPage.enterTargetValue(targetValue);
	        goalPage.clickgoalset();
	      //  System.out.println(" Goal submitted: " + goalName + " with target " + targetValue);

	        //  Navigate to Dashboard and verify goal
	        DashboardPage dash = new DashboardPage(driver);
	        dash.goToDashboard();
	        logger.info("Navigated to Dashboard.");
	      
	    
	        
	        
	        
	        
	        
	        
	        
	        Assert.assertTrue(dash.isGoalPresent(goalName), 
	                "Expected goal '" + goalName + "' not found on dashboard.");
	        logger.info("Goal verified on dashboard.");
	        
	        
	        
	        
	        
	        
	        
	        
	        // for update
	        dash.clickUpdateProgress(goalName);
	        dash.updateProgress(progressValue);
	        logger.info("Progress updated to " + progressValue);

	        Assert.assertTrue(dash.isUpdateSuccessful(), "Progress update confirmation message not found.");
	        logger.info("Progress update confirmed with success message.");
	        
	    }
	
	 }

	


