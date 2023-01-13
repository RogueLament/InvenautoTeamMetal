package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteMapPage extends PageObject
{

	public SiteMapPage(WebDriver driver) {
		super(driver);
	}

	public BlousePage clickonBlousePage() {
	
		var link = this.driver.findElement(By.linkText("Blouse"));
		link.click();

		return new BlousePage(this.driver);

	}

}
