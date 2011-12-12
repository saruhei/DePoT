package jp.ac.waseda.cs.washi.yahoo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooTopPage extends AbstractPage {

	@FindBy(name = "p")
	private WebElement searchbox;
	@FindBy(id = "srchbtn")
	private WebElement searchbtn;
	@FindBy(id = "isearch")
	private WebElement isearchbtn;

	public YahooTopPage(WebDriver driver) throws ClassNotFoundException {
		super(driver);
		// 不変条件のテスト
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is("Yahoo! JAPAN"));
	}

	public YahooSearchResultPage goSearchPage(String keyword)
			throws ClassNotFoundException {
		searchbox.sendKeys(keyword);
		searchbtn.click();
		return new YahooSearchResultPage(driver, keyword);
	}

	public YahooImageSearchResultPage goImageSearchPage(String keyword)
			throws ClassNotFoundException {
		searchbox.sendKeys(keyword);
		isearchbtn.click();
		return new YahooImageSearchResultPage(driver, keyword);
	}
}
