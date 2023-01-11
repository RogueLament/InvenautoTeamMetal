import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import foundation.DriverManagerFactory;
import foundation.TestBase;

public class SanityTests extends TestBase {
	@Test
	public void canUseVar() {
		String myString = "Taylo  rDennis";
		var myVarString = "Dennis";			  
	}
	
	@Test
	public void canLaunchChromeDriver() {
		var browserType = "chrome";
		
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		//this.driver = ;
		
		assertTrue(this.manager.getDriver() != null, "the driver should be launched");
	}
}
