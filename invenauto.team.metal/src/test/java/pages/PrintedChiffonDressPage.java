package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.JQuery.TextBoxControlExtension;

public class PrintedChiffonDressPage extends ProductPageObject {
	@FindBy(how = How.ID, using = "quantityAvailable")
	private WebElement availableQuantityElement;

	public PrintedChiffonDressPage(WebDriver driver) {
		super(driver);
	}
	
	private String getAvailableQuantity() {
		return availableQuantityElement.getText();
	}
	
	public PrintedChiffonDressPage enterMoreThanAvailableQuantity() {
		TextBoxControlExtension quantityTextBox = new TextBoxControlExtension(quantityElement);
		quantityTextBox.setValue(getAvailableQuantity());
		return this;
	}
	
	public PrintedChiffonDressPage clickAddToCart() {
		addToCartElement.click();
		return this;
	}
}
