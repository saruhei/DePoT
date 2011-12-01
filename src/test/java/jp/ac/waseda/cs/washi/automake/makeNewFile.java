package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class makeNewFile {
	public String[] makeFile() throws Exception{
		System.out.println("Input File Name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filename = br.readLine();
		System.out.println("Input Directory Address:");
		String Address = br.readLine();
		String rtst[] = new String[3]; 
		try {
			File fl = new File(Address + filename + ".java");
			fl.createNewFile();
			rtst[0] = checkAbstractPage(Address);
		} catch (IOException e) {
			System.out.println("ファイル作成失敗");
		}
		rtst[1] = Address + filename + ".java";
		rtst[2] = filename;
		return rtst;
	}

	public String checkAbstractPage(String address) throws Exception {
		File abst = new File(address + "AbstractPage.java");
		if(abst.exists() == false){
			WriteAbstractPage ab = new WriteAbstractPage(abst);
			return ab.writeAbstract();
		}else{
			return null;	
		}
	}

}
