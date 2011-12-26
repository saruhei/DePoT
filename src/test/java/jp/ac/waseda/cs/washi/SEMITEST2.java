package jp.ac.waseda.cs.washi;

import java.util.concurrent.TimeUnit;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;

import jp.ac.waseda.cs.washi.forseminar.*;
import jp.ac.waseda.cs.washi.assertion.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SEMITEST2 {

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
	public void doSEMITEST2() throws SecurityException,
	IllegalArgumentException, NoSuchMethodException,
	IllegalAccessException, InvocationTargetException,
	ClassNotFoundException, InstantiationException  {
		Starter st = new Starter(driver);
		st.goDePoThomePage()
			.goChat()
			.gogoHome()
			.goDiary()
			.doAssert(new AssertFunction<DiaryPage>() {
				
				@Override
				public void assertPage(DiaryPage page) {
					assertNotNull(page.goHome);
					assertTitle("DePoTダイアリー",driver);
					
				}
			})
			.gogoHome()
			.gogbbs()
			.gogoHome();
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
