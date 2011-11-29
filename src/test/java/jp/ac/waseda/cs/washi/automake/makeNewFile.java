package jp.ac.waseda.cs.washi.automake;

import java.io.File;
import java.io.IOException;

public class makeNewFile {
	public String makeFile(){
		try {
			File fl = new File("./src/test/java/jp/ac/waseda/cs/washi/makepage/testpage.java");
			fl.createNewFile();
		} catch (IOException e) {
			System.out.println("ファイル作成失敗");
		}
		return "./src/test/java/jp/ac/waseda/cs/washi/makepage/testpage.java";
	}

}
