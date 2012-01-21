package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class DiaryPage extends AbstractPage<DiaryPage> {

	@FindBy(id =  "goHome")
	public WebElement goHome;

	@FindBy(name =  "password")
	public WebElement password;

	@FindBy(css =  "input[value = \"管理\"]")
	public WebElement 管理;

	public DiaryPage(WebDriver driver)
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

	public DiaryPage goDiaryPageForm2() throws Exception {
		password.sendKeys("HogeHoge");
		管理.submit();
		return new DiaryPage(driver);
	}

}
