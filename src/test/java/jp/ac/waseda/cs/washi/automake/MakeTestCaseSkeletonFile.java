package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeTestCaseSkeletonFile {
	public String[] makeSkeleton() throws IOException{
		System.out.println("Input TestCase Name:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String testcaseName = br.readLine();
		System.out.println("Input Directory Address of TestCase:");
		String address = br.readLine();
		String names[] = new String[4];
		try {
			File fl = new File(address + testcaseName + ".java");
			fl.createNewFile(); 
		} catch (Exception e) {
			System.out.println("ファイル作成失敗");
		}
		System.out.println("Input Package Name Of TestCase:");
		String testpackageName = br.readLine();
		System.out.println("Input Package Name Of PageObjects:");
		String pagePackageName = br.readLine();
		names[0] = testpackageName;
		names[1] = address + testcaseName + ".java";
		names[2] = testcaseName;
		names[3] = pagePackageName;
		return names;
	}
}
