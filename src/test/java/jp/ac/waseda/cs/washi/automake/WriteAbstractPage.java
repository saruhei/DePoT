package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteAbstractPage {

	private File abst;

	public WriteAbstractPage(File abst) {
		this.abst = abst;
	}

	public String writeAbstract(String packageName) throws Exception {
		abst.createNewFile();
		FileReader readabst = new FileReader(
				"./src/test/java/jp/ac/waseda/cs/washi/automake/AbstractPage.java");
		BufferedReader br = new BufferedReader(readabst);
		PrintWriter ab = new PrintWriter(new BufferedWriter(
				new FileWriter(abst)));
		String s;
		while ((s = br.readLine()) != null) {
			if (s.startsWith("package")) {
				ab.println("package " + packageName + ";\n");
			} else {
				ab.println(s);
			}
		}
		ab.close();
		return packageName;
	}

}
