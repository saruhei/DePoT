package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage extends AbstractPage<ChatPage> {

	@FindBy(id =  "goHome")
	private WebElement goHome;

	@FindBy(name =  "name")
	private WebElement name;

	@FindBy(name =  "message")
	private WebElement message;

	public ChatPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is("DePoTチャット")); //make some invariant test if you need
	}

	public DePoThomePage gogoHome() throws ClassNotFoundException {
		goHome.click();
		return new DePoThomePage(driver);
	}

	/*public InputPageClass goWithPutname() throws ClassNotFoundException {
		name.sendKeys("HogeHoge");
		name.submit();
		return new InputPageClass(driver);
	}

	public InputPageClass goWithPutmessage() throws ClassNotFoundException {
		message.sendKeys("HogeHoge");
		message.submit();
		return new InputPageClass(driver);
	}*/

}
