package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeNewFile {
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
		System.out.println("Input Package Name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String packageName = br.readLine();
		if (abstractpage.exists() == false) {
			WriteAbstractPage ab = new WriteAbstractPage(abstractpage);
			ab.writeAbstract(packageName);
		}
		if (starter.exists() == false) {
			WriteStarter st = new WriteStarter(starter);
			st.writeStarter(packageName);
		}
		return packageName;
	}

}
