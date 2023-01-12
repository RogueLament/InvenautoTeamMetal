package pages;

import org.openqa.selenium.WebDriver;

public class TShirtPage extends PageObject
{

	public TShirtPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage clickonfadedshortsleeveShirt() {
		var productContainer = getProductContainerWithDescription("T-shirt");
		mouseover(productContainer);
		productContainer.clickMore();

		return new ProductDetailPage(this.driver);

	}

}