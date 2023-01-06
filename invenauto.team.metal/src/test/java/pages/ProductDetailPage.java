package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends PageObject
{

	public ProductDetailPage(WebDriver driver)
{
	super(driver);

}

public String getProductTitle()
{
	var element = this.driver.findElement(By.cssSelector("#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1"));

	return element.getText();
}

}