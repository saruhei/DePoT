package jp.ac.waseda.cs.washi.yahoo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import jp.ac.waseda.cs.washi.automake.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooImageSearchResultPage extends
		AbstractPage<YahooImageSearchResultPage> {

	@FindBy(id = "SaB")
	public WebElement returntop;
	@FindBy(id = "srch")
	public WebElement searchbtn;

	private final String keyword;

	public YahooImageSearchResultPage(WebDriver driver, String keyword)
			throws ClassNotFoundException, SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		super(driver);
		this.keyword = keyword;
		// 不変条件のテスト
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		// assertThat(driver.getTitle(), is("「" + keyword
		// + "」の検索結果 - Yahoo!検索（画像）"));
	}

	public YahooTopPage goTopPage() throws ClassNotFoundException,
			SecurityException, NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		returntop.click();
		return new YahooTopPage(driver);
	}

	public YahooSearchResultPage goSearchPage() throws ClassNotFoundException,
			SecurityException, NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		searchbtn.click();
		return new YahooSearchResultPage(driver, keyword);
	}
}
