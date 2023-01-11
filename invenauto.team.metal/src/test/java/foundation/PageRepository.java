package foundation;

import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class PageRepository {
	WebDriver driver;
	PageRepository(WebDriver driver) {
		this.driver = driver;
	}
	public HomePage homePage() {
		return new HomePage(this.driver);
	}

	
}
