package org.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseMethods {

	public static WebDriver driver;

	public static FileReader reader;

	public static Properties props;

	public static void launchbrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\KrishnakumarV\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--window-size=1920,1080");
		driver = new ChromeDriver(options);
	}

	public static void maxbrowser() {

		driver.manage().window().maximize();
	}

	public static void url(String link) {

		driver.get(link);

	}

	public static String pageTitle() {

		String title = driver.getTitle();

		return title;

	}

	public static void implicitWait(int time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void close() {

		driver.close();
	}

	public static void sendkeys(WebElement element, String value) {

		element.sendKeys(value);

	}

	public static void click(WebElement element) {

		element.click();

	}

	public static void fileRead(String filename) throws IOException {

		reader = new FileReader(filename);

		props = new Properties();

		props.load(reader);

	}
}
