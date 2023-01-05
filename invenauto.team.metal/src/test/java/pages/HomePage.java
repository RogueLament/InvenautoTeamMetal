package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage navigate() {
		this.driver.get("https://invenauto.tech/index.php");
		return this;
	}
}
