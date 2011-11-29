package jp.ac.waseda.cs.washi.automake;

import java.util.ArrayList;
import java.util.List;

public class makePage {
	
	public static void main(String[] args) throws Exception{
		
		makeNewFile fl = new makeNewFile();
		String flAddress = fl.makeFile();
		List<String> idList = new ArrayList<String>();
		idList = nekoHTML_test.getId();
		writePage wp = new writePage(idList);
		wp.write(flAddress);
	}

}
