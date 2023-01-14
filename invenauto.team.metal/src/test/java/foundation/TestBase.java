package foundation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
	protected DriverManager manager;
	protected PageRepository pageRepository;
	protected String browserType;
	protected String baseURL;
	private WebDriver driver;
	//private Setting settings;

	@BeforeMethod
	public void setup() {
		readFile();
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = manager.getDriver();
		var manage = this.driver.manage();
		manage.window().maximize();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.pageRepository = new PageRepository(this.driver, this.baseURL);

	}

	@AfterMethod
	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}

	public PageRepository visit() {
		return this.pageRepository;
	}

	private void readFile() {
		try {
			File options = new File("Options.txt");
			Scanner myReader = new Scanner(options);
			while (myReader.hasNextLine()) {
				String data = myReader.next();
				if (data.equals("Browser:")) {
					browserType = myReader.next();
				} else if (data.equals("Site:")) {
					baseURL = myReader.next();					
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
