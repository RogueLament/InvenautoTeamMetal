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
}
