package jp.ac.waseda.cs.washi.automake;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakePage {
	

	public static void main(String[] args) throws Exception {
		
		File file = new File("./src/test/java/jp/ac/waseda/cs/washi/automake/input.txt");
		Scanner scan = new Scanner(file);
		
		String version = scan.next();
		
		LineNumberReader fin = new LineNumberReader(new FileReader(file));
		
		while(null!= (fin.readLine()));
		
		int number = fin.getLineNumber();
		String getscan[] = new String[number + 2]; 
		int x = 0;
		while(scan.hasNext()){
			getscan[x] = scan.next();
			x = x + 1;
		}
		
		System.out.println("make only PageObjectFiles : input1");
		System.out.println("make only TestCases : input2");
		System.out.println("make both TestCases and PageObjectFiles: input3");
		

		
		if(version.equals("1")){
			System.out.println("How many PageObjectFiles will you make?:");
			makePOs(Integer.parseInt(getscan[0]),getscan);
		}
		
		else if(version.equals("2")){
			System.out.println("How many TestCases will you make?:");
			makeTCs(Integer.parseInt(getscan[0]),getscan,null);
		}
		
		else if(version.equals("3")){
			int[] numbers = new int[2];
			System.out.println("How many PageObjectFiles will you make?:");
			numbers[0] = Integer.parseInt(getscan[0]);
			System.out.println("How many TestCases will you make?:");
			numbers[1] = Integer.parseInt(getscan[1]);
			makeBoth(numbers[0],numbers[1],getscan);
		}else{
			System.out.println("invalid number");
		}
		
	}

	private static void makeBoth(int poNumber, int tcNumber, String[] getscan) throws Exception {
		String partitionPO[] = new String[4 + (2 * poNumber)];
		for(int i = 1; i <= (3 + (2 * poNumber)); i++){
			partitionPO[i] = getscan[1 + i];
		}
		String poPackageName = makePOs(poNumber,partitionPO);
		String partitionTC[] = new String[4 + tcNumber];
		for(int i = 1; i <= (3 + tcNumber); i++){
			partitionTC[i] = getscan[3 + (2 * poNumber) + i];
		}
		makeTCs(tcNumber,partitionTC,poPackageName);
	}

	private static void makeTCs(int readLine, String[] getscan, String poPackageName) throws IOException {
		String[] names = new String[4];
		for(int i = 0 ; i < readLine ; i++){
			System.out.println("Input TestCase Name@" + i+1 + ":");
			if(poPackageName == null){
				if(i == 0){
					names[0] = getscan[1];
				}else{
					names[0] = getscan[4 + i];
				}
			}else{
				if(i == 0){
					names[0] = getscan[1];
				}else{
					names[0] = getscan[3 + i];
				}
			}
			if(i == 0){
				System.out.println("Input Directory Address of TestCase:");
				names[1] = getscan[2];
				System.out.println("Input Package Name Of TestCase:");
				names[2] = getscan[3];
				if(poPackageName == null){
					System.out.println("Input Package Name Of PageObjects:");
					names[3] = getscan[4];	
				}else{
					names[3] = poPackageName;
				}
			}
			MakeTestCaseSkeletonFile fl = new MakeTestCaseSkeletonFile();
			String namesAndAddress[] = fl.makeSkeleton(names[0],names[1],names[2],names[3]);
			WriteTestCase wtc = new WriteTestCase();
			wtc.writeTest(namesAndAddress);
		}
	}

	private static String makePOs(int readLine, String[] getscan) throws Exception {
		MakeDependencyXml dependency = new MakeDependencyXml();
		dependency.makeXml("./src/test/java/jp/ac/waseda/cs/washi/dependency/",getscan,readLine);
		String[] names = new String[3];
		for(int i = 0 ; i < readLine ; i++){
			System.out.println("Input PageObjectFile Name@" + i+1 + ":");
			if(i == 0){
				names[0] = getscan[1];
			}else{
				names[0] = getscan[3 + (2 * i)];
			}
			if(i == 0){
				System.out.println("Input Directory Address:");
				names[1] = getscan[2];
				System.out.println("Input Package Name:");
				names[2] = getscan[3];
			}
			MakePageObjectFile fl = new MakePageObjectFile();
			String nameAndAddress[] = fl.makeFile(names[0],names[1],names[2]);
			List<List<String>> idList = new ArrayList<List<String>>();
			GetIdwithNekoHTML neko = new GetIdwithNekoHTML();
			idList = neko.getId(getscan[4 + (2 * i)]);
			WritePage wp = new WritePage(idList,names[1]);
			wp.write(nameAndAddress);
		}
		return names[2];
		
	}

}
