package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class DePoThome extends AbstractPage<DePoThome> {

	@FindBy(id = "GoLogin")
	public WebElement GoLogin;

	@FindBy(id = "Chat")
	public WebElement Chat;

	@FindBy(id = "Diary")
	public WebElement Diary;

	@FindBy(id = "gbbs")
	public WebElement gbbs;

	public DePoThome(WebDriver driver) throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is(driver.getTitle())); // make some
																// invariant
																// test if you
																// need
	}

	public LoginPage goGoLogin() throws ClassNotFoundException {
		GoLogin.click();
		return new LoginPage(driver);
	}

	public ChatPage goChat() throws ClassNotFoundException {
		Chat.click();
		return new ChatPage(driver);
	}

	public DiaryPage goDiary() throws ClassNotFoundException {
		Diary.click();
		return new DiaryPage(driver);
	}

	public GbbsPage gogbbs() throws ClassNotFoundException {
		gbbs.click();
		return new GbbsPage(driver);
	}

}
