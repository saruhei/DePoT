package jp.ac.waseda.cs.washi.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import jp.ac.waseda.cs.washi.automake.AbstractPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class ProxyWebElement implements WebElement {

	private AbstractPage<?> page;
	private WebElement element;

	public ProxyWebElement(AbstractPage<?> page, WebElement element) {
		this.page = page;
		this.element = element;
	}

	@Override
	public void clear() {
		doInvariantAssert();
		element.clear();
	}

	@Override
	public void click() {
		doInvariantAssert();
		element.click();
	}

	@Override
	public WebElement findElement(By arg0) {
		doInvariantAssert();
		return element.findElement(arg0);
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		doInvariantAssert();
		return element.findElements(arg0);
	}

	@Override
	public String getAttribute(String arg0) {
		doInvariantAssert();
		return element.getAttribute(arg0);
	}

	@Override
	public String getCssValue(String arg0) {
		doInvariantAssert();
		return element.getCssValue(arg0);
	}

	@Override
	public Point getLocation() {
		doInvariantAssert();
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		doInvariantAssert();
		return element.getSize();
	}

	@Override
	public String getTagName() {
		doInvariantAssert();
		return element.getTagName();
	}

	@Override
	public String getText() {
		doInvariantAssert();
		return element.getText();
	}

	@Override
	public boolean isDisplayed() {
		doInvariantAssert();
		return element.isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		doInvariantAssert();
		return element.isEnabled();
	}

	@Override
	public boolean isSelected() {
		doInvariantAssert();
		return element.isSelected();
	}

	@Override
	public void sendKeys(CharSequence... arg0) {
		doInvariantAssert();
		element.sendKeys(arg0);
	}

	@Override
	public void submit() {
		doInvariantAssert();
		element.submit();
	}

	public void doInvariantAssert() {
		if (!(new Throwable().getStackTrace()[3].getMethodName()
				.equals("assertInvariant"))) {
			Class<?> thisclass = page.getClass();
			try {
				Method assertmethod = thisclass
						.getDeclaredMethod("assertInvariant");
				assertmethod.setAccessible(true);
				assertmethod.invoke(page);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				System.out
						.println("invariant assertion have args or you have no invariant asssert method");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

}
