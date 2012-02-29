package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteDependencyXml {

	public void writedependency(File fl, String[][] urlPaseSet, int readLine, File dat) {
		PrintWriter pw;
		try {
			FileReader read = new FileReader(dat);
			BufferedReader br = new BufferedReader(read);
			pw = new PrintWriter(new BufferedWriter(new FileWriter(fl)));
			String s;
			boolean flag;
			while ((s = br.readLine()) != null){
				flag = false;
				for(int i = 0; i < readLine; i++){
					if(s.startsWith("<link href = " + '"' + urlPaseSet[i][0] + '"')){
						flag = true;
					}
				}
				if(flag == false){
					pw.println(s);
				}
			}
			br.close();
			read.close();
			write(pw,urlPaseSet,readLine);
			
			pw.close();
			
			copyTodat(pw,dat,fl);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void copyTodat(PrintWriter pw, File dat, File fl) {
		try {
			FileReader read = new FileReader(fl);
			BufferedReader br = new BufferedReader(read);
			pw = new PrintWriter(new BufferedWriter(new FileWriter(dat)));
			String s;
			while ((s = br.readLine()) != null){
				pw.println(s);
			}
			pw.close();
			read.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void write(PrintWriter pw, String[][] urlPaseSet, int readLine) {
		
		for(int i = 0; i < readLine; i++){
			pw.println("<link href = " + '"' + urlPaseSet[i][0] + '"' +  " Page =" + '"' + urlPaseSet[i][1] + '"' + "></link>");
		}
	}

}
