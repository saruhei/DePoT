package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteNecessaryObject {

	private File file;

	public WriteNecessaryObject(File file) {
		this.file = file;
	}

	public void writeNecessary(String packageName, FileReader read) throws Exception {
		file.createNewFile();
		BufferedReader br = new BufferedReader(read);
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
	}

}
