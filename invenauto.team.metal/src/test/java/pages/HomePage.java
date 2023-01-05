package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage navigate() {
		this.driver.get("https://invenauto.tech/index.php");
		return this;
	}
	
	public HomePage clickPrintedChiffonDress() {
		var PrintedChiffonDressLink = this.driver.findElements(By.xpath("//a[@title='Printed Chiffon Dress' and @class='product-name']"));
		
		PrintedChiffonDressLink.get(0).click();
		return this;
	}
}
