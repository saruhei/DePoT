package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteAbstractPage {

	private File file;

	public WriteAbstractPage(File file) {
		this.file = file;
	}

	public String writeAbstract(String packageName) throws Exception {
		file.createNewFile();
		FileReader readabst = new FileReader(
				"./src/test/java/jp/ac/waseda/cs/washi/automake/AbstractPage.java");
		BufferedReader br = new BufferedReader(readabst);
		PrintWriter pw = new PrintWriter(new BufferedWriter(
				new FileWriter(file)));
		String s;
		while ((s = br.readLine()) != null) {
			if (s.startsWith("package")) {
				pw.println("package " + packageName + ";\n");
			} else {
				pw.println(s);
			}
		}
		pw.close();
		return packageName;
	}

}
