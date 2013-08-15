package jp.ac.waseda.cs.washi.test_PO_test1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class DiaryPage extends AbstractPage<DiaryPage> {

	@FindBy(id =  "chat")
	public WebElement chat;

	@FindBy(id =  "main")
	public WebElement main;

	public DiaryPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat("DairyPage",is(driver.getTitle())); //make some invariant test if you need
	}

	public ChatPage gochat() throws ClassNotFoundException {
		chat.click();
		return new ChatPage(driver);
	}

	public MainPage gomain() throws ClassNotFoundException {
		main.click();
		return new MainPage(driver);
	}

}
