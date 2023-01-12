package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controlExtensionsJQuery.TextBoxControlExtension;

public class BlousePage extends ProductPageObject {

	public BlousePage(WebDriver driver){
		super(driver);
	}

	public String getProductTitle() {
		var element = this.driver.findElement(By.cssSelector("#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1"));
		return element.getText();
	}
	
	public BlousePage clickAddToCart() {
		addToCartElement.click();
		return this;
	}
	
	public BlousePage enterValueIntoQuantity(String value) {
		TextBoxControlExtension quantityTextBox = new TextBoxControlExtension(quantityElement);
		quantityTextBox.clear();
		quantityTextBox.setValue(value);
		return this;
	}

}