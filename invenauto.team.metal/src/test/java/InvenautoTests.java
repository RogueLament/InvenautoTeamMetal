import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import foundation.DriverManagerFactory;
import foundation.TestBase;
import pages.Gloves;
import pages.HomePage;
import pages.PrintedChiffonDressPage;

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
	public void getErrorWhenAddingMoreThanAvailbleStockToCart() {
		var expectedError = "There are not enough products in stock.";

		new HomePage(driver).navigate().clickPrintedChiffonDress();

		PrintedChiffonDressPage printedChiffonDressPage = new PrintedChiffonDressPage(driver).enterMoreThanAvailableQuantity().clickAddToCart();

		var actualError = printedChiffonDressPage.getErrorText();
		Assert.assertEquals(actualError, expectedError);
	}

	@Test
	public void getSuccessMessageWhenAddingOneItemToCart() {
		var expectedMessage = "Product successfully added to your shopping cart";

		new HomePage(driver).navigate().clickPrintedChiffonDress();

		PrintedChiffonDressPage printedChiffonDressPage = new PrintedChiffonDressPage(driver).clickAddToCart();

		var actualMessage = printedChiffonDressPage.getSuccessText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test
	public void getErrorMessageWhenAddingLetterToQuantities() {
		var expectedError = "Null quantity.";

		new HomePage(driver).navigate().clickGloves();

		Gloves glovesPage = new Gloves(driver).enterEIntoQuantity().clickAddToCart();

		var actualError = glovesPage.getErrorText();
		Assert.assertEquals(actualError, expectedError, "Entering e into the quantities should remove the number and we should get a null error due to there being no quantity");
	}

	@Test
	public void viewFadedShortSleeveTshirtPage() {
		cleanup();
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
		cleanup();
		var browserType = "chrome";

		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = this.manager.getDriver();
		
		var expectedTitle = "Blouse";

		HomePage page = new HomePage(driver);
		var actualTitle = page.navigate().clickonSiteMap().clickonBlousePage().getProductTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");

	}

	@Test
	public void navigatetoFadedShortSleevesTshitthroughTshirtPage() {
		cleanup();
		var browserType = "chrome";

		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = this.manager.getDriver();

		var expectedTitle = "Faded Short Sleeves T-shirt";

		HomePage page = new HomePage(driver);

		var actualTitle = page.navigate().clickonTshirtTab().clickonfadedshortsleeveShirt().getShortSleeveShirtTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");

	}

	@Test
	public void navigatePrintedChiffonDress() {
		cleanup();
		var browserType = "chrome";

		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = this.manager.getDriver();

		var expectedResult = "Printed chiffon knee length dress with tank straps. Deep v-neckline.";

		HomePage page = new HomePage(driver);

		var actualResult = page.navigate().printedChiffonDress().getPrintedChiffonDressDescription();

		assertEquals(expectedResult, actualResult, "product detail page should contain correct title.");
	}
}
