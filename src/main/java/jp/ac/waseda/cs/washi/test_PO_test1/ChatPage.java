package jp.ac.waseda.cs.washi.test_PO_test1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class ChatPage extends AbstractPage<ChatPage> {

	@FindBy(id =  "main")
	public WebElement main;

	@FindBy(id =  "diary")
	public WebElement diary;

	@FindBy(name =  "name")
	public WebElement name;

	@FindBy(name =  "content")
	public WebElement content;

	@FindBy(css =  "input[value = \"submit\"]")
	public WebElement submit;

	public ChatPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat("ChatPage",is(driver.getTitle())); //make some invariant test if you need
	}

	public MainPage gomain() throws ClassNotFoundException {
		main.click();
		return new MainPage(driver);
	}

	public DiaryPage godiary() throws ClassNotFoundException {
		diary.click();
		return new DiaryPage(driver);
	}

	public ChatPage goinputForm(String input_name, String input_content) throws Exception { //手動で変更
		name.sendKeys(input_name); //手動で変更
		content.sendKeys(input_content); //手動で変更
		submit.submit();
		return new ChatPage(driver);
	}

}
