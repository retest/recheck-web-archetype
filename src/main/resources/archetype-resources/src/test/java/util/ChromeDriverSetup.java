package ${package}.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class ChromeDriverSetup {

	public static ChromeDriver create() {
		// If ChromeDriver (http://chromedriver.chromium.org/downloads/) is not in your PATH, uncomment this and point to your installation.
		//		System.setProperty( "webdriver.chrome.driver", "path/to/chromedriver" );

		final ChromeOptions opts = new ChromeOptions();
		opts.addArguments(
				// Enable headless mode for faster execution.
				"--headless",
				// Use Chrome in container-based enviroments.
				"--no-sandbox", "--disable-dev-shm-usage",
				// Fix window size for stable results.
				"--window-size=1200,800" );
		final ChromeDriver chromeDriver = new ChromeDriver( opts );
		return chromeDriver;
	}

}
