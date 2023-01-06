package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage navigate() {
		this.driver.get("https://invenauto.tech/index.php");
		return this;
	}
	
	public HomePage clickPrintedChiffonDress() {
		var PrintedChiffonDressLink = this.driver.findElements(By.xpath("//a[@title='Printed Chiffon Dress' and @class='product-name']"));
		
		PrintedChiffonDressLink.get(0).click();
		return this;
	}
	
	public SignInPage clickSignInLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[class='login']"));
		menuLink.click();	
		
		return new SignInPage(this.driver);
	}
	
	public ProductDetailPage clickProductLink()
	{
		var link = this.driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default > span"));
		link.click();

		return new ProductDetailPage(this.driver);
	}

	public SiteMapPage clickonSiteMap()
	{

		var link = this.driver.findElement(By.cssSelector("#block_various_links_footer > ul > li:nth-child(8) > a"));
		link.click();

		return new SiteMapPage(this.driver);
	}
}
