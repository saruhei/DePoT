package jp.ac.waseda.cs.washi.test_PO_test1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class MainPage extends AbstractPage<MainPage> {

	@FindBy(id =  "chat")
	public WebElement chat;

	@FindBy(id =  "diary")
	public WebElement diary;

	public MainPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat("MainPage",is(driver.getTitle())); //make some invariant test if you need
	}

	public ChatPage gochat() throws ClassNotFoundException {
		chat.click();
		return new ChatPage(driver);
	}

	public DiaryPage godiary() throws ClassNotFoundException {
		diary.click();
		return new DiaryPage(driver);
	}

}
