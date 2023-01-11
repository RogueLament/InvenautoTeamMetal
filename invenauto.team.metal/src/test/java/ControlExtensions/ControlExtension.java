package ControlExtensions;

import org.openqa.selenium.WebElement;

public abstract class ControlExtension {

	protected WebElement mappedElement;

	public ControlExtension(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	

	public WebElement getElement() {
		return this.mappedElement;
	}

	
}
