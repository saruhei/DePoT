package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class ChatPage extends AbstractPage<ChatPage> {

	@FindBy(id =  "goHome")
	public WebElement goHome;

	@FindBy(name =  "name")
	public WebElement name;

	@FindBy(name =  "message")
	public WebElement message;

	public ChatPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need
	}

	public DePoThome gogoHome() throws ClassNotFoundException {
		goHome.click();
		return new DePoThome(driver);
	}

	public InputPageClass goWithPutname() throws ClassNotFoundException {
		name.sendKeys("HogeHoge");
		name.submit();
		return new InputPageClass(driver);
	}

	public InputPageClass goWithPutmessage() throws ClassNotFoundException {
		message.sendKeys("HogeHoge");
		message.submit();
		return new InputPageClass(driver);
	}

}
