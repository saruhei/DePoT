package jp.ac.waseda.cs.washi.page;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	protected final WebDriver driver;

	public AbstractPage(WebDriver driver) throws ClassNotFoundException {
		this.driver = driver;
		// ページファクトリによるフィールドの初期化
		PageFactory.initElements(driver, this);
		PrintStackTrace();
	}

	protected abstract void assertInvariant();

	public List<String> getGoMethodNames(AbstractPage that)
			throws ClassNotFoundException {
		// TODO: this(このインスタンス)が持っているメソッドの中で，goから始まるメソッド名を返すコードを作る
		// リフレクション(Reflection)を使う
		String name = that.getClass().getName();
		Class<?> cls = Class.forName(name);
		Method method[] = cls.getDeclaredMethods();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().matches("go.*")) {
				list.add(method[i].getName().toString());
			}
		}
		return list;
	}

	public AbstractPage goRandomPage() throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException, InstantiationException {
		// メソッドのランダム呼び出し（引数なし）
		String name = this.getClass().getName();
		Class<?> cls;
		cls = Class.forName(name);
		Method method[] = cls.getDeclaredMethods();
		List<String> paramList = new ArrayList<String>();
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().matches("go.*")) {
				Class<?>[] params = method[i].getParameterTypes();
				if (params.length == 0) {
					paramList.add(method[i].getName().toString());
				}
			}
		}
		if (paramList.size() == 0) {
			return null;
		} else {
			Random rnd = new Random();
			int ran = rnd.nextInt(paramList.size());
			Method done = cls.getMethod(paramList.get(ran));
			return (AbstractPage) done.invoke(this);
		}

	}
	
	public void PrintStackTrace() throws ClassNotFoundException{
		String name = this.getClass().getName();
		System.out.println(name.toString());
	}
	
	
}