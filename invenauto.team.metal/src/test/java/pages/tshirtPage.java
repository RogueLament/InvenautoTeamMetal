package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tshirtPage extends PageObject
{

	public tshirtPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage clickonfadedshortsleeveShirt() {
		
		var link = this.driver.findElement(By.cssSelector("#product_list > li > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default > span"));
		link.click();

		return new ProductDetailPage(this.driver);

	}

}