package jp.ac.waseda.cs.washi;

import java.util.concurrent.TimeUnit;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import jp.ac.waseda.cs.washi.forseminar.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SEMITEST {

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
	public void doSEMITEST() throws SecurityException,
	IllegalArgumentException, NoSuchMethodException,
	IllegalAccessException, InvocationTargetException,
	ClassNotFoundException, InstantiationException  {
		Starter st = new Starter(driver);
		st.goDePoThomePage()
			.goChat()
			.gogoHome()
			.goDiary()
			.gogoHome()
			.doUnEx(new UnExpectAction<GbbsPage, DePoThomePage>() {

				@Override
				public <T> GbbsPage unExpectAct(DePoThomePage page)
						throws ClassNotFoundException {
					page.passwd.sendKeys("aiueo");
					assertNotNull(page.passwd);
					System.out.println(page.passwd.getAttribute("type"));
					page.gbbs.click();
					return new GbbsPage(driver);
				}
			})
			.gogoHome()
			.goChat()
		/*.goHogeHoge()
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
