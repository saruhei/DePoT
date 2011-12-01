package jp.ac.waseda.cs.washi.makepage;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	protected final WebDriver driver;
	private static Stack<String> stackTrace = new Stack<String>();

	public AbstractPage(WebDriver driver) throws ClassNotFoundException {
		this.driver = driver;
		// ページファクトリによるフィールドの初期化
		PageFactory.initElements(driver, this);
		printStackTrace();
	}

	protected abstract void assertInvariant();

	public List<String> getGoMethodNames(AbstractPage that)
			throws ClassNotFoundException {
		// TODO: this(このインスタンス)が持っているメソッドの中で，goから始まるメソッド名を返すコードを作る
		// リフレクション(Reflection)を使う
		Method method[] = this.getClass().getDeclaredMethods();
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
		Method methods[] = this.getClass().getDeclaredMethods();
		List<String> paramList = new ArrayList<String>();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith("go")) {
				Class<?>[] params = method.getParameterTypes();
				if (params.length == 0) {
					paramList.add(method.getName().toString());
				}
			}
		}
		if (paramList.size() == 0) {
			return null;
		} else {
			Random rnd = new Random();
			int ran = rnd.nextInt(paramList.size());
			Method done = this.getClass().getMethod(paramList.get(ran));
			return (AbstractPage) done.invoke(this);
		}

	}

	public void printStackTrace() throws ClassNotFoundException {
		stackTrace.add(this.getClass().getName());
		for (String pageName : stackTrace) {
			System.out.println(pageName);
		}
		System.out.println();
	}

}