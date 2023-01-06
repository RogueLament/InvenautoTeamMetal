package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends PageObject{

	@FindBy(how=How.CLASS_NAME, using="logout")
	private WebElement SignOutElement;
	
	public AccountPage(WebDriver driver) {
		super(driver);
	}

	public String getSignOutButton() {
		return this.SignOutElement.getText();
	}
}
