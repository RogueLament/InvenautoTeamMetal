package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TShirtPage extends PageObject
{

	public TShirtPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage clickonfadedshortsleeveShirt() {
		var productContainer = getProductContainerWithDescription("T-shirt");
		mouseover(productContainer);
		new Actions(driver)
        .moveByOffset(10, 10)
        .perform();
		productContainer.clickMore();

		return new ProductDetailPage(this.driver);

	}

}