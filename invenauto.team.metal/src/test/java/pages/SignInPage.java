package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import controlExtensionsJQuery.TextBoxControlExtension;

public class SignInPage extends PageObject {

	@FindBy(id="email")
	private WebElement emailAddressElement;

	@FindBy(id="passwd")
	private WebElement passwordElement;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/p")
	private WebElement errorElement;
	
	@FindBy(xpath="//*[@id='login_form']/div/div[1]")
	private WebElement formErrorElement;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButtonElement;

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
	
	public AccountPage clickSignIn() {
		this.signInButtonElement.click();
		return getAccountPage();
	}
}
