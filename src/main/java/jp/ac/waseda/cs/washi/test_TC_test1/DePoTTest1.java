package jp.ac.waseda.cs.washi.test_TC_test1;

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

public class DePoTTest1 {

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
	public void doDePoTTest1() throws Exception{
		Starter st = new Starter(driver);
		st.goFirstPage()
		.gochat()
		.goinputForm("saru", "saruhei")
		.doAssert(new AssertFunction<ChatPage>(){

			@Override
			public void assertPage(ChatPage page) {
				// TODO Auto-generated method stub
				page.assertTextPresent("saru");
				
			}
		}).gomain();
	}
	
	@Test
	public void doDePoTTest2() throws Exception{
		Starter st = new Starter(driver);
		st.goFirstPage()
		.gochat()
		.goinputForm("<script>alert(aaaa)<script>", "null")
		.doAssert(new AssertFunction<ChatPage>(){

			@Override
			public void assertPage(ChatPage page) {
				// TODO Auto-generated method stub
				page.assertTextPresent("alert");
				
			}
		}).gomain();
	}
	
	@Test
	public void doDePoTTest3() throws Exception{
		Starter st = new Starter(driver);
		st.goFirstPage()
		.gochat()
		.goinputForm("goma", "Today is rain")
		.doAssert(new AssertFunction<ChatPage>(){

			@Override
			public void assertPage(ChatPage page) {
				// TODO Auto-generated method stub
				page.assertTextPresent("rain");
				
			}
		}).gomain();
	}
	
	@Test
	public void doDePoTTest4() throws Exception{
		Starter st = new Starter(driver);
		st.goFirstPage()
		.gochat()
		.goinputForm("saru", "My name is saruhei")
		.doAssert(new AssertFunction<ChatPage>(){

			@Override
			public void assertPage(ChatPage page) {
				// TODO Auto-generated method stub
				page.assertTextPresent("My name is saruhei");
				
			}
		}).gomain();
	}
	
	@Test
	public void doDePoTTest5() throws Exception{
		Starter st = new Starter(driver);
		st.goFirstPage()
		.gochat()
		.goinputForm("saruhei", "↑ is strange man")
		.doAssert(new AssertFunction<ChatPage>(){

			@Override
			public void assertPage(ChatPage page) {
				// TODO Auto-generated method stub
				page.assertTextPresent("↑ is strange man");
				
			}
		}).gomain();
	}

}
