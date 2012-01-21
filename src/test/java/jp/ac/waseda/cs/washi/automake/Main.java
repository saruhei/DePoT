package jp.ac.waseda.cs.washi.automake;

public class Main {

	public static void main(String[] args) throws Exception {
		Making make = new Making();
		make.makepages("./src/test/java/jp/ac/waseda/cs/washi/dependency/DePoTconfig.xml");
	}

}
