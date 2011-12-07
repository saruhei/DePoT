package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteStarter {

	private File starter;

	public WriteStarter(File starter) {
		this.starter = starter;
	}

	public void writeStarter(String packageName) throws IOException {
		starter.createNewFile();
		FileReader readstart = new FileReader("./src/test/java/jp/ac/waseda/cs/washi/automake/Starter.txt");
		BufferedReader br = new BufferedReader(readstart);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(starter)));
		String s;
		while((s = br.readLine()) != null){
			if(s.startsWith("package")){
				pw.println("package " + packageName + ";\n");
			}else{
				pw.println(s);
			}
		}
		pw.close();
	}

}
