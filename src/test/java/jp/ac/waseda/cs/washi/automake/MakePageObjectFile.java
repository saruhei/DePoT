package jp.ac.waseda.cs.washi.automake;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MakePageObjectFile {
	public String[] makeFile(String filename, String address, String packageName) throws Exception {
		String names[] = new String[3];
		try {
			File fl = new File(address + filename + ".java");
			fl.createNewFile();
			checkAbstractPage(address,packageName);
		} catch (IOException e) {
			System.out.println("既存のため、ファイル作成失敗、続行するとファイルは上書きされます");
		}
		names[0] = packageName;
		names[1] = address + filename + ".java";
		names[2] = filename;
		return names;
	}

	public void checkAbstractPage(String address, String packageName) throws Exception {
		File abstractpage = new File(address + "AbstractPage.java");
		File starter = new File(address + "Starter.java");
		File assertFuc = new File(address + "AssertFunction.java");
		File unEx = new File(address + "UnExpectAction.java");
		if (abstractpage.exists() == false) {
			FileReader readabst = new FileReader(
					"./src/test/java/jp/ac/waseda/cs/washi/automake/AbstractPage.java");
			WriteNecessaryObject ab = new WriteNecessaryObject(abstractpage);
			ab.writeNecessary(packageName,readabst);
		}
		if (starter.exists() == false) {
			FileReader readstart = new FileReader("./src/test/java/jp/ac/waseda/cs/washi/automake/Starter.txt");
			WriteNecessaryObject st = new WriteNecessaryObject(starter);
			st.writeNecessary(packageName,readstart);
		}
		if(assertFuc.exists() == false){
			FileReader readassert = new FileReader("./src/test/java/jp/ac/waseda/cs/washi/automake/AssertFunction.java");
			WriteNecessaryObject as = new WriteNecessaryObject(assertFuc);
			as.writeNecessary(packageName, readassert);
		}
		if(unEx.exists() == false){
			FileReader readunEx = new FileReader("./src/test/java/jp/ac/waseda/cs/washi/automake/UnExpectAction.java");
			WriteNecessaryObject ue = new WriteNecessaryObject(unEx);
			ue.writeNecessary(packageName, readunEx);
		}
	}

}
