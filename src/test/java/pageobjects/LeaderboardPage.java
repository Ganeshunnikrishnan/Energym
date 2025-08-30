package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import java.util.List;
//import org.openqa.selenium.By;
public class LeaderboardPage {

	WebDriver driver;
	
	public LeaderboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//table//tr/td[1]")
    List<WebElement> leaderboardUsers;

    @FindBy(xpath = "//table//tr")
    List<WebElement> leaderboardRows;
	
public boolean userleaderboard(String username) {
	for (WebElement user : leaderboardUsers) {
        if (user.getText().equalsIgnoreCase(username)) {
            return true;
        }
    }
    return false;
}
	
public String getProgressForUser(String username) {
    int progressColumnIndex = -1;

    if (leaderboardRows.isEmpty()) return null;

    // Find progress column index from header row
    List<WebElement> headers = leaderboardRows.get(0).findElements(org.openqa.selenium.By.tagName("th"));
    for (int i = 0; i < headers.size(); i++) {
        if (headers.get(i).getText().trim().equalsIgnoreCase("Progress")) {
            progressColumnIndex = i;
            break;
        }
    }

    if (progressColumnIndex == -1) {
        System.out.println("Progress column not found.");
        return null;
    }

    // Check data rows (skip header)
    for (int i = 1; i < leaderboardRows.size(); i++) {
        List<WebElement> cells = leaderboardRows.get(i).findElements(org.openqa.selenium.By.tagName("td"));
        if (!cells.isEmpty() && cells.get(0).getText().equalsIgnoreCase(username)) {
            if (progressColumnIndex < cells.size()) {
                return cells.get(progressColumnIndex).getText().trim();
            }
        }
    }

    return null;
}
}
