package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class makeNewFile {
	public String makeFile() throws IOException{
		System.out.println("Input File Name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filename = br.readLine();
		System.out.println("Input Directory Address:");
		String Address = br.readLine();
		try {
			File fl = new File(Address + filename + ".java");
			fl.createNewFile();
		} catch (IOException e) {
			System.out.println("ファイル作成失敗");
		}
		return Address + filename + ".java";
	}

}
