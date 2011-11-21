package jp.ac.waseda.cs.washi.page;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooSearchResultPage extends AbstractPage {

	@FindBy(id = "SaB")
	private WebElement returntop;
	@FindBy(id = "isrch")
	private WebElement isearchbtn;

	private final String keyword;

	public YahooSearchResultPage(WebDriver driver, String keyword) throws ClassNotFoundException {
		super(driver);
		this.keyword = keyword;
		// 不変条件のテスト
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is("「" + keyword + "」の検索結果 - Yahoo!検索"));
	}

	public YahooTopPage goTopPage() throws ClassNotFoundException {
		returntop.click();
		return new YahooTopPage(driver);
	}

	public YahooImageSearchResultPage goImageSearchPage() throws ClassNotFoundException {
		isearchbtn.click();
		return new YahooImageSearchResultPage(driver, keyword);
	}
}
