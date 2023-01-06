import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

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
	

	var expectedTitle = "Faded Short Sleeves T-shirt";

	HomePage page = new HomePage(driver);
	var actualTitle = page.navigate().clickProductLink().getProductTitle();

	assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	//assertTrue(this.driver != null, "the driver should be launched");
	}

	@Test
	public void navigatetoBlousePagethroughSitemapPage() {
	

	var expectedTitle = "Blouse";

	HomePage page = new HomePage(driver);
	//var actualTitle = page.navigate().clickonSiteMap().clickonBlousePage().getProductTitle();

	//assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	//assertTrue(this.driver != null, "the driver should be launched");
	}
	
	@Test
	public void canSignInWithValidInfoWithEnterKey() {
		var expectedResult = "Sign out";
		
		var actualResult = new HomePage(this.driver)
				.navigate()
				.clickSignInLink()
				.setEmailAddress("nateswenson93@gmail.com")
				.setPassword("TestTest5")
				.pressEnter()
				.getAccountPage()
				.getSignOutButton();
		
		Assert.assertEquals(actualResult, expectedResult, "The sign out button text should be 'Sign out'");
	}
	
	@Test
	public void cantSignInWithoutValidPassword() {
		var expectedResult = "There is 1 error";
		
		var actualResult = new HomePage(this.driver)
				.navigate()
				.clickSignInLink()
				.setEmailAddress("nateswenson93@gmail.com")
				.setPassword("TestTest")
				.pressEnter()
				.getErrorText();
		
		Assert.assertEquals(actualResult, expectedResult, "The error text should be 'There is 1 error'");
	}
}
