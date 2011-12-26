package jp.ac.waseda.cs.washi.automake;

import java.io.IOException;

public class MakeTestCase {
	
	public static void main(String[] args) throws IOException{
		MakeTestCaseSkeletonFile fl = new MakeTestCaseSkeletonFile();
		String names[] = fl.makeSkeleton();
		WriteTestCase wtc = new WriteTestCase();
		wtc.writeTest(names);
	}

}
