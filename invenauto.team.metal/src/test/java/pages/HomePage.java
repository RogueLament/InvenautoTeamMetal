package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage navigate(String baseURL) {
		this.driver.get(baseURL);
		return this;
	}
	
	public PrintedChiffonDressPage clickPrintedChiffonDress() {
		var PrintedChiffonDressLink = this.driver.findElements(By.xpath("//a[@title='Printed Chiffon Dress' and @class='product-name']"));
		
		PrintedChiffonDressLink.get(0).click();
		return new PrintedChiffonDressPage(this.driver);
	}
	
	public SignInPage clickSignInLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[class='login']"));
		menuLink.click();	
		
		return new SignInPage(this.driver);
	}
	
	public GlovesPage clickGloves() {
		var GlovesLink = this.driver.findElement(By.xpath("//a[@title='Gloves' and @class='product-name']"));
		
		GlovesLink.click();
		return new GlovesPage(this.driver);
	}
	
	public ProductDetailPage clickProductLink()
	{
		var link = this.driver.findElements(By.cssSelector("#homefeatured a.button.lnk_view.btn.btn-default"))
				.get(0);
		link.click();

		return new ProductDetailPage(this.driver);
	}

	public SiteMapPage clickonSiteMap()
	{

		var link = this.driver.findElement(By.cssSelector("#block_various_links_footer > ul > li:nth-child(8) > a"));
		link.click();

		return new SiteMapPage(this.driver);
	}
	
	public TShirtPage clickonTshirtTab() {
		var tshirtLink = this.driver.findElements(By.cssSelector("#block_top_menu a[title*='T-shirt']")).get(1);
		tshirtLink.click();
		return new TShirtPage(this.driver);
	}
	
	public ProductDetailPage printedChiffonDress() {
		getProductContainerWithDescription("Printed Chiffon Dress")
		.clickMore();
		return new ProductDetailPage(this.driver);
	}

	public HomePage focusFirstProduct() {
		var productContainer = this.driver.findElement(By.cssSelector(".product-container"));
		mouseover(productContainer);
		return this;
	}
	
	public HomePage focusProductContainerWithDescription(String desc) {
		var productContainer = getProductContainerWithDescription(desc);
		mouseover(productContainer);
		return this;
	}
	
	public BlousePage clickBlouse() {
		var BlouseLink = this.driver.findElements(By.xpath("//a[@title='Blouse' and @class='product-name']"));
		
		BlouseLink.get(0).click();
		return new BlousePage(this.driver);
	}

	public Dress6Page clickPrintesSummerDress6() {
		var DressLink = this.driver.findElements(By.xpath("//a[contains(text(),'Printed Summer Dress')]"));
		
		DressLink.get(1).click();
		return new Dress6Page(this.driver);
	}

}
