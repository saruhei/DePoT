package jp.ac.waseda.cs.washi.page;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	protected final WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		// ページファクトリによるフィールドの初期化
		PageFactory.initElements(driver, this);
	}
	
	protected abstract void assertInvariant();
	
	public List<String> getGoMethodNames(AbstractPage that) throws ClassNotFoundException {
		// TODO: this(このインスタンス)が持っているメソッドの中で，goから始まるメソッド名を返すコードを作る
		// リフレクション(Reflection)を使う
		String name = that.getClass().getName();
		Class<?> cls = Class.forName(name);
		Method method[] = cls.getDeclaredMethods(); 
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < method.length ; i++){
			if(method[i].getName().matches("go.*")){
			list.add(method[i].getName().toString());
			}
		}
		return list;
	}
}