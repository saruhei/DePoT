package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.Selenium;

public abstract class AbstractPage<Tpage extends AbstractPage<Tpage>> {
	protected final WebDriver driver;
	protected Selenium selenium;
	private static Stack<String> stackTrace = new Stack<String>();

	public AbstractPage(WebDriver driver) throws ClassNotFoundException {
		this.driver = driver;
		// ページファクトリによるフィールドの初期化
		selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
		PageFactory.initElements(driver, this);
		printStackTrace();
	}

	protected abstract void assertInvariant();
	
	public <T> Tpage doAssert(AssertFunction<Tpage> assertFunction){
		assertFunction.assertPage((Tpage)this);
		return (Tpage) this;	
	}
	
	public <T, T2> T doUnEx(UnExpectAction<T,T2> UnEx) throws ClassNotFoundException{
		return (T)UnEx.unExpectAct((T2)this);	
	}
	
	public List<String> getGoMethodNames()
			throws ClassNotFoundException {
		Method method[] = this.getClass().getDeclaredMethods();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().matches("go.*")) {
				list.add(method[i].getName().toString());
			}
		}
		System.out.println(list.toString());
		return list;
	}

	public AbstractPage<?> goRandomPage() throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException, InstantiationException {
		// メソッドのランダム呼び出し（引数なし）
		Method methods[] = this.getClass().getDeclaredMethods();
		List<String> methodNames = new ArrayList<String>();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith("go")) {
				Class<?>[] params = method.getParameterTypes();
				if (params.length == 0) {
					methodNames.add(method.getName().toString());
				}
			}
		}
		if (methodNames.size() == 0) {
			return null;
		} else {
			Random rnd = new Random();
			int ran = rnd.nextInt(methodNames.size());
			Method goMethod = this.getClass().getMethod(methodNames.get(ran));
			return (AbstractPage<?>) goMethod.invoke(this);
		}

	}

	public void printStackTrace() throws ClassNotFoundException {
		stackTrace.add(this.getClass().getName());
		String delimiter = "";
		for(String pageName : stackTrace){
			System.out.println(pageName + delimiter);
			delimiter = ",";
		}
		System.out.println("");
	}
	
	
	public void assertTitle(String title){
		assertThat(driver.getTitle(), is(title));
	}
	
	public void assertUrl(String url){
		assertThat(driver.getCurrentUrl(), is(url));
	}
	
	public void assertWindowHandle(String handle){
		assertThat(driver.getWindowHandle(), is(handle));
	}
	
	public void assertTag(String tag,WebElement element){
		assertThat(element.getTagName(),is(tag));
	}
	
	public void assertText(String text, WebElement element){
		assertThat(element.getText(), is(text));
	}
	
	public void assertTextPresent(String text){
		assertTrue(selenium.isTextPresent(text));
	}
	
	public void assertSize(Dimension size, WebElement element){
		assertEquals(size, element.getSize());
	}
	
	public void assertPoint(Point location,WebElement element){
		assertEquals(location, element.getLocation());
	}
	
	public void assertDisplayed(WebElement element){
		assertTrue(element.isDisplayed());
	}
	
	public void assertEnabled(WebElement element){
		assertTrue(element.isEnabled());
	}
	
	public void assertSelected(WebElement element){
		assertTrue(element.isSelected());
	}
	
	public void assertAttribute(String Attribute, String expected, WebElement element){
		assertThat(element.getAttribute(Attribute), is(expected));
	}
	
	public void assertCssValue(String Value, String expected, WebElement element){
		assertThat(element.getCssValue(Value), is(expected));
	}



}