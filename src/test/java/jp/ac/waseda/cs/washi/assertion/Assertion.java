package jp.ac.waseda.cs.washi.assertion;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.Selenium;

public class Assertion {
	
	
	public static void assertTitle(String title,WebDriver driver){
		assertThat(driver.getTitle(), is(title));
	}
	
	public static void assertUrl(String url,WebDriver driver){
		assertThat(driver.getCurrentUrl(), is(url));
	}
	
	public static void assertWindowHandle(String handle,WebDriver driver){
		assertThat(driver.getWindowHandle(), is(handle));
	}
	
	public static void assertTag(String tag,WebElement element){
		assertThat(element.getTagName(),is(tag));
	}
	
	public static void assertText(String text, WebElement element){
		assertThat(element.getText(), is(text));
	}
	
	public static void assertTextPresent(String text, Selenium selenium){
		assertTrue(selenium.isTextPresent(text));
	}
	
	public static void assertSize(Dimension size, WebElement element){
		assertEquals(size, element.getSize());
	}
	
	public static void assertPoint(Point location,WebElement element){
		assertEquals(location, element.getLocation());
	}
	
	public static void assertDisplayed(WebElement element){
		assertTrue(element.isDisplayed());
	}
	
	public static void assertEnabled(WebElement element){
		assertTrue(element.isEnabled());
	}
	
	public static void assertSelected(WebElement element){
		assertTrue(element.isSelected());
	}
	
	public static void assertAttribute(String Attribute, String expected, WebElement element){
		assertThat(element.getAttribute(Attribute), is(expected));
	}
	
	public static void assertCssValue(String Value, String expected, WebElement element){
		assertThat(element.getCssValue(Value), is(expected));
	}


}
