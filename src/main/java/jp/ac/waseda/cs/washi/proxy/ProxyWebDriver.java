package jp.ac.waseda.cs.washi.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import jp.ac.waseda.cs.washi.automake.AbstractPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProxyWebDriver implements WebDriver {

	private AbstractPage<?> page;
	private WebDriver driver;

	public ProxyWebDriver(AbstractPage<?> page, WebDriver driver) {
		this.page = page;
		this.driver = driver;
	}

	@Override
	public void get(String url) {
		doInvariantAssert();
		driver.get(url);
	}

	@Override
	public String getCurrentUrl() {
		doInvariantAssert();
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		doInvariantAssert();
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		doInvariantAssert();
		return driver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		doInvariantAssert();
		return driver.findElement(by);
	}

	@Override
	public String getPageSource() {
		doInvariantAssert();
		return driver.getPageSource();
	}

	@Override
	public void close() {
		doInvariantAssert();
		driver.close();
	}

	@Override
	public void quit() {
		doInvariantAssert();
		driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		doInvariantAssert();
		return driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		doInvariantAssert();
		return driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		doInvariantAssert();
		return driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		doInvariantAssert();
		return driver.navigate();
	}

	@Override
	public Options manage() {
		doInvariantAssert();
		return driver.manage();
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
