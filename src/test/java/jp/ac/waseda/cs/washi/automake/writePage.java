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

	public WritePage(List<List<String>> methodLists) {
		this.methodLists = methodLists;
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

	public void input(File file, String packageName, String fileName) {

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

	public void writeClass(PrintWriter pw, String string) {
		pw.println("public class " + string + " extends AbstractPage {\n");

		writeFindBy(pw, methodLists.get(0), methodLists.get(1),
				methodLists.get(2), methodLists.get(3));

		writeConstructor(pw, string);

		writeAssert(pw, string);

		writeMethod(pw, methodLists.get(0), methodLists.get(1),
				methodLists.get(2), methodLists.get(3));

		pw.println("}");
	}

	public void writeimport(PrintWriter pw) {
		pw.println("import static org.hamcrest.Matchers.is;\n"
				+ "import static org.junit.Assert.assertThat;\n"
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
			List<String> textNameList) {

		for (int i = 0; i < idList.size(); i++) {
			pw.println("	public InputPageClass go" + idList.get(i)
					+ "() throws ClassNotFoundException {\n" + "		"
					+ idList.get(i) + ".click();\n"
					+ "		return new InputPageClass(driver);\n" + "	}\n");
		}
		for (int i = 0; i < nameList.size(); i++) {
			pw.println("	public InputPageClass go" + idList.get(i)
					+ "() throws ClassNotFoundException {\n" + "		"
					+ nameList.get(i) + ".click();\n"
					+ "		return new InputPageClass(driver);\n" + "	}\n");
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

	public void writeAssert(PrintWriter pw, String string) {
		pw.println("	@Override\n"
				+ "	protected void assertInvariant() {\n"
				+ "		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need\n"
				+ "	}\n");
		pw.println("	public "
				+ string
				+ " assertNotInvariant() throws ClassNotFoundException{\n"
				+ "		assertThat(driver.getTitle(), is(driver.getTitle())); //make some not invariant test if you need\n"
				+ "		return new " + string + "(driver);\n" + "	}\n");
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
					+ "	private WebElement " + id + ";\n");
		}
		for (String textid : textidList) {
			pw.println("	@FindBy(id =  " + '"' + textid + '"' + ")\n"
					+ "	private WebElement " + textid + ";\n");
		}
		for (String name : nameList) {
			pw.println("	@FindBy(name =  " + '"' + name + '"' + ")\n"
					+ "	private WebElement " + name + ";\n");
		}
		for (String textname : textnameList) {
			pw.println("	@FindBy(name =  " + '"' + textname + '"' + ")\n"
					+ "	private WebElement " + textname + ";\n");
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
