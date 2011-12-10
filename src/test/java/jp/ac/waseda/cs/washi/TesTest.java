package jp.ac.waseda.cs.washi;

import java.util.concurrent.TimeUnit;

import jp.ac.waseda.cs.washi.makepage.Starter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testest {

	private static FirefoxDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void dotestest() throws ClassNotFoundException {
		Starter st = new Starter(driver);
		st/*.goHogeHoge()
			.goChomeChome()
			.goSomewhare(String)*/;
	}

}
