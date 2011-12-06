package jp.ac.waseda.cs.washi;

import java.util.concurrent.TimeUnit;

import jp.ac.waseda.cs.washi.forseminar.Starter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DePoTest {

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
	public void DTest() throws ClassNotFoundException {
		Starter st = new Starter(driver);
		st.goDePoThomePage().goDiary().goHome().gogbbs().goHome();
	}
}
