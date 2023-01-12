package pages;

import org.openqa.selenium.WebDriver;

import controlExtensionsJQuery.TextBoxControlExtension;

public class Gloves extends ProductPageObject{
	public Gloves(WebDriver driver) {
		super(driver);
	}
	
	public Gloves enterValueIntoQuantity(String value) {
		TextBoxControlExtension quantityTextBox = new TextBoxControlExtension(quantityElement);
		quantityTextBox.clear();
		quantityTextBox.setValue(value);
		return this;
	}
	
	public Gloves clickAddToCart() {
		addToCartElement.click();
		return this;
	}
}
