package jp.ac.waseda.cs.washi.automake;

import java.io.File;
import java.io.IOException;

public class MakeDependencyXml {
	
	public void makeXml(String address, String[] getscan, int readLine){
		String urlPaseSet[][] = new String[readLine][2];
		for(int i = 0; i < readLine; i++){
			urlPaseSet[i][0] = getscan[4 + ( 2 * i )];
			if(i == 0){
				urlPaseSet[i][1] = getscan[1];
			}else{
				urlPaseSet[i][1] = getscan[3 + (2 * i)];
			}
		}
		try {
			File dir = new File(getscan[2]);
			String xmlname = dir.getName();
			File fl = new File(address + xmlname + ".xml");
			File dat = new File(address + xmlname + ".dat");
			if(fl.exists() == false){
				fl.createNewFile();
				dat.createNewFile();
			}
			WriteDependencyXml depend = new WriteDependencyXml();
			depend.writedependency(fl,urlPaseSet,readLine,dat);
		} catch (IOException e) {
			System.out.println("既存のため、ファイル作成失敗、続行するとファイルは上書きされます");
		}
	}

}
