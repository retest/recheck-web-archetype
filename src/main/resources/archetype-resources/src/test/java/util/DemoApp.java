package ${package}.util;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class DemoApp {

	static public String loginFormUrl() throws MalformedURLException {
		final Path filePath = Paths.get( "src/test/resources/pages/demo-app/login-form.html" );
		return filePath.toUri().toURL().toString();
	}

}
