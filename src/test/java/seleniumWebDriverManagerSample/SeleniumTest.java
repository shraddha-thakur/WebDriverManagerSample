package seleniumWebDriverManagerSample;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//		WebDriverManager.firefoxdriver().setup();
		//		WebDriverManager.edgedriver().setup();
		//		WebDriverManager.operadriver().setup();
		//		WebDriverManager.chromiumdriver().setup()
		//		WebDriverManager.iedriver().setup();

		//		String driverVersion1 = WebDriverManager.chromedriver().getDownloadedDriverVersion();
		//		System.out.println(driverVersion1);

		List<String> driverVersion = WebDriverManager.chromedriver().getDriverVersions();
		System.out.println(driverVersion);

		//		Object downloadedDriverVersion = WebDriverManager.chromedriver().getDownloadedDriverVersion();
		//		System.out.println(downloadedDriverVersion);
		//

		Optional<Path> browserPath = WebDriverManager.chromedriver().getBrowserPath();
		System.out.println(browserPath);

		//		assumeThat(browserPath).isPresent();

		driver.manage().window().maximize();
		//		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://google.com");
		System.out.println("Browser Opened");

		driver.quit();
		System.out.println("Browser quit");
	}
}
