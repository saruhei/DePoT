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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class Experience1_notdepot {

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
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("saru");
		driver.findElement(By.name("content")).sendKeys("My name is saruhei");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("saru");
		selenium.isTextPresent("My name is saruhei");		
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}
	
	@Test
	public void doDePoTTest2() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("diary")).click();
		assertThat("DairyPage",is(driver.getTitle()));

	}
	

	@Test
	public void doDePoTTest3() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("saru");
		driver.findElement(By.name("content")).sendKeys("saruhei");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("saru");
		selenium.isTextPresent("saruhei");		
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}
	
	@Test
	public void doDePoTTest4() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));
		driver.findElement(By.id("diary")).click();
		assertThat("DairyPage",is(driver.getTitle()));

	}
	
	
	
	@Test
	public void doDePoTTest5() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("<script>alert(aaaa)<script>");
		driver.findElement(By.name("content")).sendKeys("null");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("<script>alert(aaaa)<script>");
		selenium.isTextPresent("null");		
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}
	
	@Test
	public void doDePoTTest6() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("experience1");
		driver.findElement(By.name("content")).sendKeys("pending...");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("experience1");
		selenium.isTextPresent("pending...");	
		driver.findElement(By.name("name")).sendKeys("experience1_2");
		driver.findElement(By.name("content")).sendKeys("pendingpending");
		assertThat("ChatPage",is(driver.getTitle()));
		selenium.isTextPresent("experience1");
		selenium.isTextPresent("pending...");	
		selenium.isTextPresent("experience1_2");
		selenium.isTextPresent("pendingpending");	
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}

	
	@Test
	public void doDePoTTest7() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("goma");
		driver.findElement(By.name("content")).sendKeys("Today is rain");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("goma");
		selenium.isTextPresent("Today is rain");		
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}
	
	@Test
	public void doDePoTTest8() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("saruhei");
		driver.findElement(By.name("content")).sendKeys("↑ is strange man");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("saruhei");
		selenium.isTextPresent("↑ is strange man");		
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}
	
	@Test
	public void doDePoTTest9() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));

	}
	
	@Test
	public void doDePoTTest10() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("diary")).click();
		assertThat("DairyPage",is(driver.getTitle()));
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("depot");
		driver.findElement(By.name("content")).sendKeys("not depot");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("depot");
		selenium.isTextPresent("not depot");		
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}
	
	
	
}
	

