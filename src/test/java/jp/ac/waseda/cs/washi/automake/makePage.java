package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MakePage {

	public static void main(String[] args) throws Exception {
		
		System.out.println("make only PageObjectFiles : input1");
		System.out.println("make only TestCases : input2");
		System.out.println("make both TestCases and PageObjectFiles: input3");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String version = br.readLine();
		
		if(version.equals("1")){
			System.out.println("How many PageObjectFiles will you make?:");
			makePOs(Integer.parseInt(br.readLine()));
		}
		
		else if(version.equals("2")){
			System.out.println("How many TestCases will you make?:");
			makeTCs(Integer.parseInt(br.readLine()),null);
		}
		
		else if(version.equals("3")){
			int[] numbers = new int[2];
			System.out.println("How many PageObjectFiles will you make?:");
			numbers[0] = Integer.parseInt(br.readLine());
			System.out.println("How many TestCases will you make?:");
			numbers[1] = Integer.parseInt(br.readLine());
			makeBoth(numbers[0],numbers[1]);
		}else{
			System.out.println("invalid number");
		}
		
		/*
		MakePageObjectFile fl = new MakePageObjectFile();
		String nameAndAddress[] = fl.makeFile();
		List<List<String>> idList = new ArrayList<List<String>>();
		GetIdwithNekoHTML neko = new GetIdwithNekoHTML();
		idList = neko.getId();
		WritePage wp = new WritePage(idList);
		wp.write(nameAndAddress);
		*/
	}

	private static void makeBoth(int poNumber, int tcNumber) throws Exception {
		String poPackageName = makePOs(poNumber);
		makeTCs(tcNumber,poPackageName);
	}

	private static void makeTCs(int readLine, String poPackageName) throws IOException {
		String[] names = new String[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < readLine ; i++){
			System.out.println("Input TestCase Name@" + i+1 + ":");
			names[0] = br.readLine();
			if(i == 0){
				System.out.println("Input Directory Address of TestCase:");
				names[1] = br.readLine();
				System.out.println("Input Package Name Of TestCase:");
				names[2] = br.readLine();
				if(poPackageName.equals(null)){
					System.out.println("Input Package Name Of PageObjects:");
					names[3] = br.readLine();	
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

	private static String makePOs(int readLine) throws Exception {
		String[] names = new String[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i < readLine ; i++){
			System.out.println("Input PageObjectFile Name@" + i+1 + ":");
			names[0] = br.readLine();
			if(i == 0){
				System.out.println("Input Directory Address:");
				names[1] = br.readLine();
				System.out.println("Input Package Name:");
				names[2] = br.readLine();
			}
			MakePageObjectFile fl = new MakePageObjectFile();
			String nameAndAddress[] = fl.makeFile(names[0],names[1],names[2]);
			List<List<String>> idList = new ArrayList<List<String>>();
			GetIdwithNekoHTML neko = new GetIdwithNekoHTML();
			idList = neko.getId();
			WritePage wp = new WritePage(idList);
			wp.write(nameAndAddress);
		}
		return names[2];
		
	}

}
