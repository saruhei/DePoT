package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class ChatPage extends AbstractPage<ChatPage> {

	@FindBy(id =  "goHome")
	public WebElement goHome;

	@FindBy(id =  "radioblue")
	public WebElement radioblue;

	@FindBy(id =  "radiored")
	public WebElement radiored;

	@FindBy(id =  "radiogreen")
	public WebElement radiogreen;

	@FindBy(id =  "radiobrown")
	public WebElement radiobrown;

	@FindBy(id =  "radiopurple")
	public WebElement radiopurple;

	@FindBy(name =  "name")
	public WebElement name;

	@FindBy(name =  "message")
	public WebElement message;

	@FindBy(name =  "refresh")
	public WebElement forSelectElementrefresh;
	Select refresh = new Select(forSelectElementrefresh);

	@FindBy(name =  "Submit")
	public WebElement Submit;

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

	public ChatPage goChatPageForm0() throws Exception {
		radioblue.click();
		radiored.click();
		radiogreen.click();
		radiobrown.click();
		radiopurple.click();
		name.sendKeys("HogeHoge");
		message.sendKeys("HogeHoge");
		refresh.selectByValue("ref60");
		refresh.selectByValue("ref45");
		refresh.selectByValue("ref30");
		Submit.submit();
		return new ChatPage(driver);
	}

}
