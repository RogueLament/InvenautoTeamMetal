import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import foundation.TestBase;
import pages.HomePage;

public class InvenautoTests extends TestBase{
	
	public HomePage navigateToHomePage() {
		return visit()
				.homePage()
				.navigate();
	}
	
	@Test
	public void getErrorWhenAddingMoreThanAvailbleStockToCart() {
		var expectedError = "There are not enough products in stock.";

		var actualError = navigateToHomePage()
				.clickPrintedChiffonDress()
				.enterMoreThanAvailableQuantity()
				.clickAddToCart()
				.getErrorText();

		Assert.assertEquals(actualError, expectedError, "A box with error message 'There are not enough products in stock' should appear");
	}

	@Test
	public void getSuccessMessageWhenAddingOneItemToCart() {
		var expectedMessage = "Product successfully added to your shopping cart";

		var actualMessage = navigateToHomePage()
				.clickPrintedChiffonDress()
				.clickAddToCart()
				.getSuccessText();
		
		Assert.assertEquals(actualMessage, expectedMessage, "A box with product details and message 'Product successfully added to your shopping cart' should appear");
	}

	@Test
	public void getErrorMessageWhenAddingLetterToQuantities() {
		var expectedError = "Null quantity.";

		var actualError = navigateToHomePage()
				.clickGloves()
				.enterValueIntoQuantity("e")
				.clickAddToCart()
		 		.getErrorText();

		Assert.assertEquals(actualError, expectedError, "Entering e into the quantities should remove the number and we should get a null error due to there being no quantity");
	}

	@Test
	public void viewFadedShortSleeveTshirtPage() {
		var expectedTitle = "Faded Short Sleeves T-shirt";

		var actualTitle = navigateToHomePage()
				.focusFirstProduct()
				.clickProductLink()
				.getProductTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	}

	@Test
	public void navigatetoBlousePagethroughSitemapPage() {
		var expectedTitle = "Blouse";

		var actualTitle = navigateToHomePage()
				.clickonSiteMap()
				.clickonBlousePage()
				.getProductTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	}

	@Test
	public void navigatetoFadedShortSleevesTshitthroughTshirtPage() {
		var expectedTitle = "Faded Short Sleeves T-shirt";

		var actualTitle = navigateToHomePage()
				.clickonTshirtTab()
				.clickonfadedshortsleeveShirt()
				.getShortSleeveShirtTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	}

	@Test
	public void navigateToProductDetails() {
		var expectedResult = "Printed chiffon knee length dress with tank straps. Deep v-neckline.";

		var actualResult = navigateToHomePage()
				.openPrintedChiffonDress()
				.getPrintedChiffonDressDescription();

		assertEquals(expectedResult, actualResult, "product detail page should contain correct title.");
	}

	@Test
	public void canSignInWithValidInfoWithEnterKey() {
		var expectedResult = "Sign out";

		var actualResult = navigateToHomePage()
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

		var actualResult = navigateToHomePage()
				.clickSignInLink()
				.setEmailAddress("nateswenson93@gmail.com")
				.setPassword("TestTest")
				.pressEnter()
				.getErrorText();

		Assert.assertEquals(actualResult, expectedResult, "The error text should be 'There is 1 error'");
	}

	@Test
	public void cantSignInWithoutAnAtSymbolInTheEmail() {
		var expectedResult = true;

		var actualResult = navigateToHomePage()
				.clickSignInLink()
				.setEmailAddress("user")
				.setPassword("admin")
				.pressEnter()
				.isFormErrorDisplayed();

		Assert.assertEquals(actualResult, expectedResult, "The form error element should be displayed");
	}
	
	@Test
	public void canSignInWithValidInfo() {
		var expectedResult = "Sign out";

		var actualResult = navigateToHomePage()
				.clickSignInLink()
				.setEmailAddress("user@gmail.com")
				.setPassword("admin")
				.clickSignIn()
				.getSignOutButton();

		Assert.assertEquals(actualResult, expectedResult, "The sign out button text should be 'Sign out'");
	}
	
	@Test
	public void canAddGlovesToCart() {
		String expectedText = "Product successfully added to your shopping cart";

		String actualText = navigateToHomePage()
				.clickGloves()
				.clickAddToCart()
				.getSuccessText();

		Assert.assertEquals(actualText, expectedText, "The user should receive a confirmation message");		
	}
	
	@Test
	public void getOutOfStockMessage() {
		String expectedText = "This product is no longer in stock with those attributes but is available with others.";
		
		String actualText = navigateToHomePage()
				.clickPrintesSummerDress6()
				.clickWhiteBox()
				.getOutOfStockMessage();

		Assert.assertEquals(actualText, expectedText, "The user should receive an error message stating the product is out of stock");		
	}
	
	@Test
	public void getErrorMessageWhenAddingNegativeNumberToQuantities() {
		var expectedError = "Null quantity.";

		var actualError = navigateToHomePage()
				.clickGloves()
				.enterValueIntoQuantity("-1")
				.clickAddToCart()
		 		.getErrorText();

		Assert.assertEquals(actualError, expectedError, "Entering e into the quantities should remove the number and we should get a null error due to there being no quantity");
	}
	
	@Test
	public void getSuccessMessageWhenAddingMultipleOfAnItemToCart() {
		var expectedMessage = "Product successfully added to your shopping cart";

		var actualMessage = navigateToHomePage()
				.clickBlouse()
				.clickAddToCart()
				.getSuccessText();
		
		Assert.assertEquals(actualMessage, expectedMessage, "A box with product details and message 'Product successfully added to your shopping cart' should appear");
	}
}
