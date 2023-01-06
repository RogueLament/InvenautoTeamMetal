import org.testng.Assert;
import org.testng.annotations.Test;

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
		Assert.assertEquals(actualError, expectedError);
	}
}
