package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintedChiffonDressPage extends PageObject {

	public PrintedChiffonDressPage(WebDriver driver) {
		super(driver);
	}
	
	private int getAvailableQuantity() {
		var availableQuantityLink = this.driver.findElements(By.xpath("//span[@id='quantityAvailable']"));
		return 0;
	}
}
