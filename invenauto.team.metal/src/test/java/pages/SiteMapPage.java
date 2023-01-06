package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteMapPage extends PageObject
{

	public SiteMapPage(WebDriver driver)
{
	super(driver);

}

public blousePage clickonBlousePage()
{
	var link = this.driver.findElement(By.cssSelector("#best-sellers_block_right > div > ul > li:nth-child(1) > div > h5 > a"));
	link.click();

	return new blousePage(this.driver);

}

}
