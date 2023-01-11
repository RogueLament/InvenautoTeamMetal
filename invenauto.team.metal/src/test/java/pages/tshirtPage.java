package pages;

import org.openqa.selenium.WebDriver;

public class tshirtPage extends PageObject
{

	public tshirtPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage clickonfadedshortsleeveShirt() {
		var productContainer = getProductContainerWithDescription("T-shirt");
		mouseover(productContainer);
		productContainer.clickMore();

		return new ProductDetailPage(this.driver);

	}

}