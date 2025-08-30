package testcase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import utils.LoggerManager;
import pageobjects.HomePage;
import pageobjects.LeaderboardPage;
import testbase.Baseclass;
import utils.TestData;
public class TC04_Leaderboard extends Baseclass{

	   Logger logger = LoggerManager.getLogger(this.getClass());
	
	  @Test(priority = 4)
	    public void testLeaderboardForRegisteredUser() {
		 
		  logger.info(" Starting leaderboard test for user: " + TestData.registeredUsername);
		 
	     HomePage home = new HomePage(driver);
	        home.clickLeaderboard();  
	        logger.info(" Navigated to Leaderboard page.");
	        
	        
	        
	        LeaderboardPage leaderboard = new LeaderboardPage(driver);
	        boolean isPresent = leaderboard.userleaderboard(TestData.registeredUsername);

	        Assert.assertTrue(isPresent, " User '" + TestData.registeredUsername + "' not found in leaderboard.");
	        logger.info(" User is listed in the leaderboard: " + TestData.registeredUsername);  
	      
	        
	        String actualProgress = leaderboard.getProgressForUser(TestData.registeredUsername);
	        logger.info("Fetched progress for user: " + actualProgress);

	        // ✅ Expecting progress "10" as updated in TC_03Goal
	        Assert.assertEquals(actualProgress, "10", "Progress mismatch for user in leaderboard.");
	        logger.info("Verified progress value matches expected: 10");
	  }
	
		  
	  }

