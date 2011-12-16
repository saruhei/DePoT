package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakePageObjectFile {
	public String[] makeFile() throws Exception {
		System.out.println("Input File Name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filename = br.readLine();
		System.out.println("Input Directory Address:");
		String address = br.readLine();
		String names[] = new String[3];
		try {
			File fl = new File(address + filename + ".java");
			fl.createNewFile();
			names[0] = checkAbstractPage(address);
		} catch (IOException e) {
			System.out.println("ファイル作成失敗");
		}
		names[1] = address + filename + ".java";
		names[2] = filename;
		return names;
	}

	public String checkAbstractPage(String address) throws Exception {
		File abstractpage = new File(address + "AbstractPage.java");
		File starter = new File(address + "Starter.java");
		File assertFuc = new File(address + "AssertFunction.java");
		File unEx = new File(address + "UnExpectAction.java");
		System.out.println("Input Package Name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String packageName = br.readLine();
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
		return packageName;
	}

}
