package ${package};

import ${package}.util.ChromeDriverSetup;
import ${package}.util.DemoApp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.junit.jupiter.RecheckExtension;

@ExtendWith( RecheckExtension.class ) // Takes care of `re.startTest()`, `re.capTest()` etc.
public class Option2AutomaticRecheckSetupTest {

	private WebDriver driver;
	private Recheck re;

	@BeforeEach
	public void setup() {
		driver = ChromeDriverSetup.create();
		re = new RecheckImpl();
	}

	@Test
	public void simpleTestCaseUsingLocalFile() throws Exception {
		// re.startTest() is not needed, handled by RecheckExtension

		// Do your Selenium stuff.
		driver.get( DemoApp.loginFormUrl() );

		// Single call instead of multiple assertions.
		// Create a golden master with `stepName` or check against it, don't fail on differences.
		re.check( driver, "yourStepName" );

		driver.findElement( By.id( "username" ) ).sendKeys( "admin" );
		driver.findElement( By.id( "password" ) ).sendKeys( "secret" );
		re.check( driver, "loginFormWithValidLoginData" ); // checks again the complete site

		// re.capTest() is not needed, handled by RecheckExtension
	}

	// For more examples have a look at https://github.com/retest/recheck-web-showcases

	@AfterEach
	public void tearDown() {
		driver.quit();
		// re.cap() is not needed, handled by RecheckExtension
	}

}
