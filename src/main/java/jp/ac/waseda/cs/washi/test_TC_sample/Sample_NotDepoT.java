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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class Sample_NotDepoT {

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
	public void sampleTest_notdepot() throws Exception{
		driver.get("http://develop.saruhei.com");
		driver.findElement(By.id("chat")).click();
		assertThat("ChatPage",is(driver.getTitle()));
		driver.findElement(By.name("name")).sendKeys("sample");
		driver.findElement(By.name("content")).sendKeys("sample");
		assertThat("ChatPage",is(driver.getTitle()));
		Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		selenium.isTextPresent("sample");
		selenium.isTextPresent("sample");		
		driver.findElement(By.id("main")).click();
		assertThat("MainPage",is(driver.getTitle()));

	}
		
	
}
	

