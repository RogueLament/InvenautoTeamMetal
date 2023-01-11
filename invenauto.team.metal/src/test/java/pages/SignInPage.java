package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import controlExtensionsJQuery.TextBoxControlExtension;
import pages.PageObject;

public class SignInPage extends PageObject {

	@FindBy(how=How.ID, using="email")
	private WebElement emailAddressElement;

	@FindBy(how=How.ID, using="passwd")
	private WebElement passwordElement;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]/div[1]/p")
	private WebElement errorElement;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"login_form\"]/div/div[1]")
	private WebElement formErrorElement;

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	public SignInPage setEmailAddress(String value) {
		new TextBoxControlExtension(emailAddressElement).setValue(value);

		return this;
	}

	public SignInPage setPassword(String value) {
		new TextBoxControlExtension(passwordElement).setValue(value);

		return this;
	}

	public SignInPage pressEnter() {
		this.passwordElement.sendKeys(Keys.ENTER);

		return this;
	}
	
	public AccountPage getAccountPage() {
		return new AccountPage(this.driver);
	}
	
	public String getErrorText() {
		return this.errorElement.getText();
	}
	
	public boolean isFormErrorDisplayed() {
		return this.formErrorElement.isDisplayed();
	}

}
