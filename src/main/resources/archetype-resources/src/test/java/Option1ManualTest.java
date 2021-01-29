package ${package};

import ${package}.util.ChromeDriverSetup;
import ${package}.util.DemoApp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;

public class Option1ManualTest {

	private WebDriver driver;
	private Recheck re;

	@BeforeEach
	public void setup() {
		driver = ChromeDriverSetup.create();
		re = new RecheckImpl();
	}

	@Test
	public void simpleTestCaseUsingLocalFile() throws Exception {
		re.startTest(); // Start a test and infer the test name from the calling method

		// Do your Selenium stuff.
		driver.get( DemoApp.loginFormUrl() );

		// Single call instead of multiple assertions.
		// Create a golden master with `stepName` or check against it, don't fail on differences.
		re.check( driver, "yourStepName" );

		driver.findElement( By.id( "username" ) ).sendKeys( "admin" );
		driver.findElement( By.id( "password" ) ).sendKeys( "secret" );
		re.check( driver, "loginFormWithValidLoginData" ); // checks again the complete site

		re.capTest(); // Will fail if there are differences to the golden master
	}

	// For more examples have a look at https://github.com/retest/recheck-web-showcases

	@AfterEach
	public void tearDown() {
		driver.quit();
		re.cap(); // Finishes recheck and persists the test report. Starting the review GUI is sensible
	}

}
