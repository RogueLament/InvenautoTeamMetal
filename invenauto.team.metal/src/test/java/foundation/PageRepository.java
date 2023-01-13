package foundation;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.PageObject;

public class PageRepository {
	WebDriver driver;
	PageRepository(WebDriver driver) {
		this.driver = driver;
	}
	PageRepository(WebDriver driver, String baseURL) {
		this.driver = driver;
		PageObject.setBaseURL(baseURL);
	}
	public HomePage homePage() {
		return new HomePage(this.driver);
	}

	
}
