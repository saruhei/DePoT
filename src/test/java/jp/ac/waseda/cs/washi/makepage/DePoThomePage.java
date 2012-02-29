package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DePoThomePage extends AbstractPage<DePoThomePage> {

	@FindBy(id =  "GoLogin")
	public WebElement GoLogin;

	@FindBy(id =  "Chat")
	public WebElement Chat;

	@FindBy(id =  "Diary")
	public WebElement Diary;

	@FindBy(id =  "gbbs")
	public WebElement gbbs;

	public DePoThomePage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need
	}

	public InputPageClass goGoLogin() throws ClassNotFoundException {
		GoLogin.click();
		return new InputPageClass(driver);
	}

	public ChatPage goChat() throws ClassNotFoundException {
		Chat.click();
		return new ChatPage(driver);
	}

	public DiaryPage goDiary() throws ClassNotFoundException {
		Diary.click();
		return new DiaryPage(driver);
	}

	public InputPageClass gogbbs() throws ClassNotFoundException {
		gbbs.click();
		return new InputPageClass(driver);
	}

}
