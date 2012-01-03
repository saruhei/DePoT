package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WritePage {

	private List<List<String>> methodLists = new ArrayList<List<String>>();
	private String diraddress;

	public WritePage(List<List<String>> methodLists, String names) {
		this.methodLists = methodLists;
		diraddress = names;
	}

	public void write(String[] nameAndAddress) {
		try {
			File file = new File(nameAndAddress[1]);

			if (checkBeforeWriteFile(file)) {

				input(file, nameAndAddress[0], nameAndAddress[2]);

			} else {
				System.out.println("ファイル書き込みミス");
			}

		} catch (Exception e) {
			System.out.println("書き込みミス");
		}
	}

	public void input(File file, String packageName, String fileName) throws Exception {

		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			writePackage(pw, packageName);

			writeimport(pw);

			writeClass(pw, fileName);

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeClass(PrintWriter pw, String string) throws Exception {
		pw.println("public class " + string + " extends AbstractPage<" + string
				+ "> {\n");

		writeFindBy(pw, methodLists.get(0), methodLists.get(1),
				methodLists.get(2), methodLists.get(3));

		writeConstructor(pw, string);

		writeAssert(pw);

		writeMethod(pw, methodLists.get(0), methodLists.get(1),
				methodLists.get(2), methodLists.get(3),methodLists.get(4),methodLists.get(5));

		pw.println("}");
	}

	public void writeimport(PrintWriter pw) {
		pw.println("import static org.hamcrest.Matchers.is;\n"
				+ "import static org.junit.Assert.*;\n"
				+ "import static jp.ac.waseda.cs.washi.assertion.Assertion.*;\n"
				+ "import org.openqa.selenium.WebDriver;\n"
				+ "import org.openqa.selenium.WebElement;\n"
				+ "import org.openqa.selenium.support.FindBy;\n");
	}

	private static void writePackage(PrintWriter pw, String packageName)
			throws IOException {
		pw.println("package " + packageName + ";\n");
	}

	public void writeMethod(PrintWriter pw, List<String> idList,
			List<String> nameList, List<String> textIdList,
			List<String> textNameList, List<String> idhrefList, List<String> namehrefList) throws Exception {

		for (int i = 0; i < idList.size(); i++) {
			ParseDependency pdi = new ParseDependency();
			String returnIdClass = pdi.parsedepend(idhrefList.get(i),diraddress);
			if(returnIdClass == null){
				pw.println("	public InputPageClass go" + idList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ idList.get(i) + ".click();\n"
						+ "		return new InputPageClass(driver);\n" + "	}\n");
			}else{
				pw.println("	public " + returnIdClass + " go" + idList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ idList.get(i) + ".click();\n"
						+ "		return new " + returnIdClass + "(driver);\n" + "	}\n");
			}
		}
		for (int i = 0; i < nameList.size(); i++) {
			ParseDependency pdn  = new ParseDependency();
			String returnNameClass = pdn.parsedepend(namehrefList.get(i), diraddress);
			if(returnNameClass == null){
				pw.println("	public InputPageClass go" + nameList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ nameList.get(i) + ".click();\n"
						+ "		return new InputPageClass(driver);\n" + "	}\n");
			}else{
				pw.println("	public " + returnNameClass + " go" + nameList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ nameList.get(i) + ".click();\n"
						+ "		return new " + returnNameClass + "(driver);\n" + "	}\n");
			}
		}
		for (int i = 0; i < textIdList.size(); i++) {
			pw.println("	public InputPageClass goWithPut" + textIdList.get(i)
					+ "() throws ClassNotFoundException {\n" + "		"
					+ textIdList.get(i) + ".sendKeys(\"HogeHoge\");\n" + "		"
					+ textIdList.get(i) + ".submit();\n"
					+ "		return new InputPageClass(driver);\n" + "	}\n");
		}
		for (int i = 0; i < textNameList.size(); i++) {
			pw.println("	public InputPageClass goWithPut" + textNameList.get(i)
					+ "() throws ClassNotFoundException {\n" + "		"
					+ textNameList.get(i) + ".sendKeys(\"HogeHoge\");\n" + "		"
					+ textNameList.get(i) + ".submit();\n"
					+ "		return new InputPageClass(driver);\n" + "	}\n");
		}
	}

	public void writeAssert(PrintWriter pw) {
		pw.println("	@Override\n"
				+ "	protected void assertInvariant() {\n"
				+ "		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need\n"
				+ "	}\n");
	}

	public void writeConstructor(PrintWriter pw, String string) {
		pw.println("	public " + string + "(WebDriver driver)\n"
				+ "			throws ClassNotFoundException {\n" + "		super(driver);\n"
				+ "		assertInvariant();\n" + "	}\n");
	}

	public void writeFindBy(PrintWriter pw, List<String> idList,
			List<String> nameList, List<String> textidList,
			List<String> textnameList) {
		for (String id : idList) {
			pw.println("	@FindBy(id =  " + '"' + id + '"' + ")\n"
					+ "	public WebElement " + id + ";\n");
		}
		for (String textid : textidList) {
			pw.println("	@FindBy(id =  " + '"' + textid + '"' + ")\n"
					+ "	public WebElement " + textid + ";\n");
		}
		for (String name : nameList) {
			pw.println("	@FindBy(name =  " + '"' + name + '"' + ")\n"
					+ "	public WebElement " + name + ";\n");
		}
		for (String textname : textnameList) {
			pw.println("	@FindBy(name =  " + '"' + textname + '"' + ")\n"
					+ "	public WebElement " + textname + ";\n");
		}
	}

	public boolean checkBeforeWriteFile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}
		return false;
	}

}
