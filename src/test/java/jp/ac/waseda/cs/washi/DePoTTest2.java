package jp.ac.waseda.cs.washi;

import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import java.util.concurrent.TimeUnit;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import jp.ac.waseda.cs.washi.makepage.*;
import jp.ac.waseda.cs.washi.automake.UnExpectAction;
import jp.ac.waseda.cs.washi.automake.AssertFunction;import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DePoTTest2 {

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
	public void doDePoTTest2() throws SecurityException,
	IllegalArgumentException, NoSuchMethodException,
	IllegalAccessException, InvocationTargetException,
	ClassNotFoundException, InstantiationException  {
		Starter st = new Starter(driver);
		st/*.goHogeHoge()
			.goChomeChome()
			.doAssert(new AssertFunction<InputNowPage>() {
				@Override
				public void assertPage(InputNowPage page) {
					assertNotNull(page.hoge);
				}
			})
			.doUnEx(new UnExpectAction<InputNowPage,InputNextPage>() {
				@Override
				public <T> InputNextPage unExpectAct(InputNowPage page)throws ClassNotFoundException {
					assertNotNull(page.hoge);
					page.chome.click();
					return new InputNextPage(driver);
				}
			})
			.goSomewhare(String)*/;
	}

}
