package jp.ac.waseda.cs.washi.test_TC_sample;

import java.util.concurrent.TimeUnit;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import jp.ac.waseda.cs.washi.test_PO_test1.*;
import jp.ac.waseda.cs.washi.automake.UnExpectAction;
import jp.ac.waseda.cs.washi.automake.AssertFunction;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample_Depot {

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
	public void sampleTest_depot() throws Exception{
		Starter st = new Starter(driver);
		st.goFirstPage()
		.gochat()
		.goinputForm("sample", "sample")
		.doAssert(new AssertFunction<ChatPage>(){

			@Override
			public void assertPage(ChatPage page) {
				page.assertTextPresent("sample");
				page.assertTextPresent("sample");
			}
		}).gomain();
	}
	
}
