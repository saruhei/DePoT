package jp.ac.waseda.cs.washi.yahoo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class YahooTopPage extends AbstractPage<YahooTopPage> {

	@FindBy(name = "p")
	public WebElement searchbox;
	@FindBy(id = "srchbtn")
	public WebElement searchbtn;
	@FindBy(id = "isearch")
	public WebElement isearchbtn;

	public YahooTopPage(WebDriver driver) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		super(driver);
		// 不変条件のテスト
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is("Yahoo! JAPAN"));
		assertEnabled(searchbox);
	}

	public YahooSearchResultPage goSearchPage(String keyword)
			throws ClassNotFoundException, Exception {
		searchbox.sendKeys(keyword);
		searchbtn.click();
		return new YahooSearchResultPage(driver, keyword);
	}

	public YahooImageSearchResultPage goImageSearchPage(String keyword)
			throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		searchbox.sendKeys(keyword);
		isearchbtn.click();
		return new YahooImageSearchResultPage(driver, keyword);
	}
}
