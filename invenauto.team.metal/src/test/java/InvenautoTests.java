import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import foundation.TestBase;

public class InvenautoTests extends TestBase{
	@Test
	public void getErrorWhenAddingMoreThanAvailbleStockToCart() {
		var expectedError = "There are not enough products in stock.";

		var actualError = visit().homePage()
				.navigate(this.baseURL)
				.clickPrintedChiffonDress()
				.enterMoreThanAvailableQuantity()
				.clickAddToCart()
				.getErrorText();

		Assert.assertEquals(actualError, expectedError);
	}

	@Test
	public void getSuccessMessageWhenAddingOneItemToCart() {
		var expectedMessage = "Product successfully added to your shopping cart";

		var actualMessage = visit()
				.homePage()
				.navigate(this.baseURL)
				.clickPrintedChiffonDress()
				.clickAddToCart()
				.getSuccessText();
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test
	public void getErrorMessageWhenAddingLetterToQuantities() {
		var expectedError = "Null quantity.";

		var actualError = visit()
				.homePage()
				.navigate(this.baseURL)
				.clickGloves()
				.enterValueIntoQuantity("e")
				.clickAddToCart()
		 		.getErrorText();

		Assert.assertEquals(actualError, expectedError, "Entering e into the quantities should remove the number and we should get a null error due to there being no quantity");
	}

	@Test
	public void viewFadedShortSleeveTshirtPage() {
		var expectedTitle = "Faded Short Sleeves T-shirt";

		var actualTitle = visit()
				.homePage()
				.navigate(this.baseURL)
				.focusFirstProduct()
				.clickProductLink()
				.getProductTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	}

	@Test
	public void navigatetoBlousePagethroughSitemapPage() {
		var expectedTitle = "Blouse";

		var actualTitle = visit()
				.homePage()
				.navigate(this.baseURL)
				.clickonSiteMap()
				.clickonBlousePage()
				.getProductTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	}

	@Test
	public void navigatetoFadedShortSleevesTshitthroughTshirtPage() {
		var expectedTitle = "Faded Short Sleeves T-shirt";

		var actualTitle = visit()
				.homePage()
				.navigate(this.baseURL)
				.clickonTshirtTab()
				.clickonfadedshortsleeveShirt()
				.getShortSleeveShirtTitle();

		assertEquals(expectedTitle, actualTitle, "product detail page should contain correct title.");
	}

	@Test
	public void navigatePrintedChiffonDress() {


		var expectedResult = "Printed chiffon knee length dress with tank straps. Deep v-neckline.";

		var actualResult = visit()
				.homePage()
				.navigate(this.baseURL)
				.printedChiffonDress()
				.getPrintedChiffonDressDescription();

		assertEquals(expectedResult, actualResult, "product detail page should contain correct title.");
	}

	@Test
	public void canSignInWithValidInfoWithEnterKey() {
		var expectedResult = "Sign out";

		var actualResult = visit()
				.homePage()
				.navigate(this.baseURL)
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

		var actualResult = visit()
				.homePage()
				.navigate(this.baseURL)
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

		var actualResult = visit()
				.homePage()
				.navigate(this.baseURL)
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

		var actualResult = visit()
				.homePage()
				.navigate(this.baseURL)
				.clickSignInLink()
				.setEmailAddress("user@gmail.com")
				.setPassword("admin")
				.clickSignIn()
				.getSignOutButton();

		Assert.assertEquals(actualResult, expectedResult, "The sign out button text should be 'Sign out'");
	}
	
	@Test
	public void getErrorMessageWhenAddingNegativeNumberToQuantities() {
		var expectedError = "Null quantity.";

		var actualError = visit()
				.homePage()
				.navigate(this.baseURL)
				.clickGloves()
				.enterValueIntoQuantity("-1")
				.clickAddToCart()
		 		.getErrorText();

		Assert.assertEquals(actualError, expectedError, "Entering e into the quantities should remove the number and we should get a null error due to there being no quantity");
	}
	
	@Test
	public void getSuccessMessageWhenAddingMultipleOfAnItemToCart() {
		var expectedMessage = "Product successfully added to your shopping cart";

		var actualMessage = visit()
				.homePage()
				.navigate(this.baseURL)
				.clickBlouse()
				.clickAddToCart()
				.getSuccessText();
		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
