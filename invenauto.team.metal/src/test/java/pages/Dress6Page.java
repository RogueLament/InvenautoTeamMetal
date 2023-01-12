package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dress6Page extends PageObject {

	public Dress6Page(WebDriver driver) {
		super(driver);
	}

	public Dress6Page clickWhiteBox() {
		By color = By.cssSelector("a#color_8");
		this.driver.findElement(color)
		.click();
		return this;
	}

	public String getOutOfStockMessage() {
		By availability = By.cssSelector("span#availability_value");
		var text = this.driver.findElement(availability)
				.getText();		
		return text;
	}

}
