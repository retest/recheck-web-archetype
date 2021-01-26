package ${package};

import ${package}.util.ChromeDriverSetup;
import ${package}.util.DemoApp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.web.RecheckWebOptions;
import de.retest.web.selenium.AutocheckingRecheckDriver;

public class Option3AutomaticCheckOnEachStepTest {

	private AutocheckingRecheckDriver driver;

	@BeforeEach
	public void setup() {
		final ChromeDriver chromeDriver = ChromeDriverSetup.create();

		// The AutocheckingRecheckDriver take care of setup recheck and checks the result of each selenium call,
		// like `driver.get( ... )` or `driver.findElement( ... ).click();` automatically.
		driver = new AutocheckingRecheckDriver( chromeDriver, RecheckWebOptions.builder().build() );
	}

	@Test
	public void simpleTestCaseUsingLocalFile() throws Exception {
		// Do your Selenium stuff.
		driver.get( DemoApp.loginFormUrl() );

		// You don't need `re.check( ... )`, it's done by AutocheckingRecheckDriver

		// The stepNames are per per default numbered, to change this you can set a AutocheckingCheckNamingStrategy
		// in RecheckWebOptions above.

		// If you want to do something without a following automatic check, use `skipCheck()`
		driver.skipCheck().findElement( By.id( "username" ) ).sendKeys( "admin" );

		driver.findElement( By.id( "password" ) ).sendKeys( "secret" ); // checks again the complete site
	}

	// For more examples have a look at https://github.com/retest/recheck-web-showcases

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}
