package jp.ac.waseda.cs.washi.automake;

import java.util.ArrayList;
import java.util.List;

public class MakePage {

	public static void main(String[] args) throws Exception {

		MakeNewFile fl = new MakeNewFile();
		String pNaD[] = fl.makeFile();
		List<String> idList = new ArrayList<String>();
		GetIdwithNekoHTML neko = new GetIdwithNekoHTML();
		idList = neko.getId();
		WritePage wp = new WritePage(idList);
		wp.write(pNaD);
	}

}
