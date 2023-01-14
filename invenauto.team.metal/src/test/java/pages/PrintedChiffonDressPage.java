package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import controlExtensionsJQuery.TextBoxControlExtension;

public class PrintedChiffonDressPage extends ProductPageObject {
	@FindBy(how = How.ID, using = "quantityAvailable")
	private WebElement availableQuantityElement;

	public PrintedChiffonDressPage(WebDriver driver) {
		super(driver);
	}
	
	private int getAvailableQuantity() {
		return Integer.valueOf(availableQuantityElement.getText());
	}
	
	public PrintedChiffonDressPage enterMoreThanAvailableQuantity() {
		TextBoxControlExtension quantityTextBox = new TextBoxControlExtension(quantityElement);
		var quantity = getAvailableQuantity()+1;
		quantityTextBox.setValue(String.valueOf(quantity));
		return this;
	}
	
	public PrintedChiffonDressPage clickAddToCart() {
		addToCartElement.click();
		return this;
	}
}
