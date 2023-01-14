package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ProductPageObject extends PageObject{
	@FindBy(how = How.ID, using = "quantity_wanted")
	protected WebElement quantityElement;
	@FindBy(how = How.ID, using = "add_to_cart")
	protected WebElement addToCartElement;
	@FindBy(how = How.CLASS_NAME, using = "fancybox-error")
	protected WebElement errorBox;
	
	public ProductPageObject(WebDriver driver) {
		super(driver);
	}
	
	public String getErrorText() {
		WebDriverWait wait = new WebDriverWait(this.driver,2);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='fancybox-error']")));
		return errorBox.getText();
	}
	
	public String getSuccessText() {
		WebDriverWait wait = new WebDriverWait(this.driver,2);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='layer_cart']")));
		var successText = this.driver.findElements(By.xpath("//span[@class='title']"));
		
		return successText.get(0).getText();
	}
}
