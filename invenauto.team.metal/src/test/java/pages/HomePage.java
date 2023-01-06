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
	
	public SignInPage clickSignInLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[class='login']"));
		menuLink.click();	
		
		return new SignInPage(this.driver);
	}
	
	public HomePage clickGloves() {
		var GlovesLink = this.driver.findElement(By.xpath("//a[@title='Gloves' and @class='product-name']"));
		
		GlovesLink.click();
		return this;
	}
}
