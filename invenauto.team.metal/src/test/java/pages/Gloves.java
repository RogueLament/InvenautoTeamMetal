package pages;

import org.openqa.selenium.WebDriver;

import ControlExtensions.JQuery.TextBoxControlExtension;

public class Gloves extends ProductPageObject{
	public Gloves(WebDriver driver) {
		super(driver);
	}
	
	public Gloves enterEIntoQuantity() {
		TextBoxControlExtension quantityTextBox = new TextBoxControlExtension(quantityElement);
		quantityTextBox.setValue("e");
		return this;
	}
	
	public Gloves clickAddToCart() {
		addToCartElement.click();
		return this;
	}
}
