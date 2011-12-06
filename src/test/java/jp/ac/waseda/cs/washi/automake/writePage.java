package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WritePage {

	private List<String> idList = new ArrayList<String>();

	public WritePage(List<String> idList) {
		this.idList = idList;
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

		writeFindBy(pw, idList);

		writeConstructor(pw, string);

		writeAssertInvariant(pw);

		writeMethod(pw, idList);

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

	public void writeMethod(PrintWriter pw, List<String> idList) {

		for (int i = 0; i < idList.size(); i++) {
			pw.println("	public InputPageClass " + idList.get(i)
					+ "() throws ClassNotFoundException {\n" + "		"
					+ idList.get(i) + ".click();\n"
					+ "		return new InputPageClass(driver);\n" + "	}\n");
		}
	}

	public void writeAssertInvariant(PrintWriter pw) {
		pw.println("	@Override\n" + "	protected void assertInvariant() {\n"
				+ "	}\n");
	}

	public void writeConstructor(PrintWriter pw, String string) {
		pw.println("	public " + string + "(WebDriver driver)\n"
				+ "			throws ClassNotFoundException {\n" + "		super(driver);\n"
				+ "		assertInvariant();\n" + "	}\n");
	}

	public void writeFindBy(PrintWriter pw, List<String> idList) {
		for (int i = 0; i < idList.size(); i++) {
			pw.println("	@FindBy(id =  " + '"' + idList.get(i) + '"' + ")\n"
					+ "	private WebElement " + idList.get(i) + ";\n");
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
