package jp.ac.waseda.cs.washi.automake;

import java.io.File;
import java.io.IOException;

public class MakeTestCaseSkeletonFile {
	public String[] makeSkeleton(String testcaseName, String address,
			String testpackageName, String pagePackageName) throws IOException {
		String names[] = new String[4];
		try {
			File fl = new File(address + testcaseName + ".java");
			fl.createNewFile();
		} catch (Exception e) {
			System.out.println("既存のため、ファイル作成失敗、続行するとファイルは上書きされます");
		}
		names[0] = testpackageName;
		names[1] = address + testcaseName + ".java";
		names[2] = testcaseName;
		names[3] = pagePackageName;
		return names;
	}
}
