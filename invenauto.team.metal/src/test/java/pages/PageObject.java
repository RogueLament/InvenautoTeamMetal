package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import ControlExtensions.ControlExtension;
import ControlExtensions.ProductContainer;

public abstract class PageObject {
	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		
		InitPageFactory();
	}

	private void InitPageFactory() {
		PageFactory.initElements(this.driver, this);
	}
	
	public ProductContainer getProductContainerWithDescription(String desc) {
		var productContainer = this.driver.findElement(By
				.xpath("//*[@class='product-name'][contains(@title,'" + desc + "')]"
								+ "/ancestor::div[@class='product-container']"));
		mouseover(productContainer);
		return new ProductContainer(productContainer);
	}
	
	public void mouseover(WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}
	public void mouseover(ControlExtension extension) {
		new Actions(driver).moveToElement(extension.getElement()).perform();
	}
}
