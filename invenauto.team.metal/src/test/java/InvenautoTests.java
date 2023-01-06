import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import foundation.DriverManagerFactory;
import foundation.TestBase;
import pages.HomePage;

public class InvenautoTests extends TestBase{
	@Test
	public void navigatesToPrintedChiffonDressPage() {
		var expectedValue = "https://invenauto.tech/index.php?id_product=7&controller=product";
		
		HomePage homePage = new HomePage(driver);
		homePage.navigate().clickPrintedChiffonDress();
        
        var actualValue = driver.getCurrentUrl();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	@Test
	public void viewFadedShortSleeveTshirtPage() {
	
	var browserType = "chrome";

	this.manager = DriverManagerFactory.getManager(browserType);
	this.manager.createDriver();
	this.driver = this.manager.getDriver();

	var expectedTitle = "Faded Short Sleeves T-shirt";

	HomePage page = new HomePage(driver);
	var actualTitle = page.navigate().clickProductLink().getProductTitle();

	assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	}

	@Test
	public void navigatetoBlousePagethroughSitemapPage() {
	
	var browserType = "chrome";

	this.manager = DriverManagerFactory.getManager(browserType);
	this.manager.createDriver();
	this.driver = this.manager.getDriver();

	var expectedTitle = "Blouse";

	HomePage page = new HomePage(driver);
	var actualTitle = page.navigate().clickonSiteMap().clickonBlousePage().getProductTitle();

	assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	//assertTrue(this.driver != null, "the driver should be launched");
	}
}
