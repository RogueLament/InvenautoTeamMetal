package pages;

import org.openqa.selenium.WebDriver;

import controlExtensionsJQuery.TextBoxControlExtension;

public class GlovesPage extends ProductPageObject{
	public GlovesPage(WebDriver driver) {
		super(driver);
	}
	
	public GlovesPage enterValueIntoQuantity(String value) {
		TextBoxControlExtension quantityTextBox = new TextBoxControlExtension(quantityElement);
		quantityTextBox.clear();
		quantityTextBox.setValue(value);
		return this;
	}
	
	public GlovesPage clickAddToCart() {
		addToCartElement.click();
		return this;
	}
}
