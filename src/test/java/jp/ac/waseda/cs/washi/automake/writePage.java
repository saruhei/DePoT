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
	private List<String> poPageNameLists;
	private List<String> poPageUrlLists;
	boolean Flag;

	public WritePage(List<List<String>> methodLists, String names,
			List<String> poPageNameLists, List<String> poPageUrlLists) {
		this.methodLists = methodLists;
		this.poPageNameLists = poPageNameLists;
		this.poPageUrlLists = poPageUrlLists;

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

	public void input(File file, String packageName, String fileName)
			throws Exception {

		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			writePackage(pw, packageName);

			writeimport(pw);

			writeClass(pw, fileName);

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeClass(PrintWriter pw, String string) throws Exception {
		pw.println("public class " + string + " extends AbstractPage<" + string
				+ "> {\n");

		writeFindBy(pw, methodLists.get(0), methodLists.get(1),
				methodLists.get(5), methodLists.get(6), methodLists.get(7),
				methodLists.get(8), methodLists.get(13), methodLists.get(14),
				methodLists.get(21));

		writeConstructor(pw, string);

		writeAssert(pw);

		writeLinkMethod(pw, methodLists.get(0), methodLists.get(1),
				methodLists.get(2), methodLists.get(3));

		writeFormMethod(pw, string, methodLists.get(4), methodLists.get(5),
				methodLists.get(6), methodLists.get(7), methodLists.get(8),
				methodLists.get(9), methodLists.get(10), methodLists.get(11),
				methodLists.get(12), methodLists.get(13), methodLists.get(14),
				methodLists.get(15), methodLists.get(16), methodLists.get(17),
				methodLists.get(18), methodLists.get(19), methodLists.get(20),methodLists.get(21));

		pw.println("}");
	}

	private void writeFormMethod(PrintWriter pw, String filename,
			List<String> formactionlist, List<String> formclickidList,
			List<String> formclicknamelist, List<String> formsendkeysidlist,
			List<String> formsendkeysnamelist, List<String> formclickidnumber,
			List<String> formclicknamenumber,
			List<String> formsendkeysidnumber,
			List<String> formsendkeysnamenumber, List<String> formselectidlist,
			List<String> formselectnamelist, List<String> formselectidnumber,
			List<String> formselectnamenumber,
			List<String> formselectvalueidlist,
			List<String> formselectvaluenamelist,
			List<String> formselectvalueidnumber,
			List<String> formselectvaluenamenumber, List<String> formsubmitlist) {

		for (int i = 0; i < formactionlist.size(); i++) {
			Flag = false;
			if ((i + 1) == formactionlist.size()) {
				if (Integer.parseInt(formclickidnumber.get(i)) == formclickidList
						.size()
						&& Integer.parseInt(formclicknamenumber.get(i)) == formclicknamelist
								.size()
						&& Integer.parseInt(formsendkeysidnumber.get(i)) == formsendkeysidlist
								.size()
						&& Integer.parseInt(formsendkeysnamenumber.get(i)) == formsendkeysnamelist
								.size()) {
					Flag = true;
				}
			} else {
				if (Integer.parseInt(formclickidnumber.get(i)) == Integer
						.parseInt(formclickidnumber.get(i + 1))
						&& Integer.parseInt(formclicknamenumber.get(i)) == Integer
								.parseInt(formclicknamenumber.get(i + 1))
						&& Integer.parseInt(formsendkeysidnumber.get(i)) == Integer
								.parseInt(formsendkeysidnumber.get(i + 1))
						&& Integer.parseInt(formsendkeysnamenumber.get(i)) == Integer
								.parseInt(formsendkeysnamenumber.get(i + 1))) {
					Flag = true;
				}
			}

			if (Flag == false) {

				String returnIdClass = null;
				for (int j = 0; j < poPageUrlLists.size(); j++) {
					if (poPageUrlLists.get(j).endsWith(formactionlist.get(i))) {
						returnIdClass = poPageNameLists.get(j);
					}
				}
				if (formactionlist.get(i).equals("$PHP_SELF")) {
					pw.println("	public " + filename + " goForm" + i
							+ "() throws Exception {");
				} else if (returnIdClass == null) {
					pw.println("	public InputPageClass goForm" + i
							+ "() throws Exception {");
				} else {
					pw.println("	public " + returnIdClass + " goForm" + i
							+ "() throws Exception {");
				}

				if ((i + 1) == (formactionlist.size())) {
					for (int j = Integer.parseInt(formclickidnumber.get(i)); j < formclickidList
							.size(); j++) {
						pw.println("		" + formclickidList.get(j) + ".click();");
					}
					for (int j = Integer.parseInt(formclicknamenumber.get(i)); j < formclicknamelist
							.size(); j++) {
						pw.println("		" + formclicknamelist.get(j)
								+ ".click();");
					}
					for (int j = Integer.parseInt(formsendkeysidnumber.get(i)); j < formsendkeysidlist
							.size(); j++) {
						pw.println("		" + formsendkeysidlist.get(j)
								+ ".sendKeys(\"HogeHoge\");");
					}
					for (int j = Integer
							.parseInt(formsendkeysnamenumber.get(i)); j < formsendkeysnamelist
							.size(); j++) {
						pw.println("		" + formsendkeysnamelist.get(j)
								+ ".sendKeys(\"HogeHoge\");");
					}
					for (int j = Integer.parseInt(formselectidnumber.get(i)); j < formselectidlist
							.size(); j++) {
						if ((j + 1) == formselectvalueidnumber.size()) {
							for (int k = Integer
									.parseInt(formselectvalueidnumber.get(j)); k < formselectvalueidlist
									.size(); k++) {
								pw.println("		" + formselectidlist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvalueidlist.get(k) + '"'
										+ ");");
							}
						} else {
							for (int k = Integer
									.parseInt(formselectvalueidnumber.get(j)); k < Integer
									.parseInt(formselectvalueidnumber
											.get(j + 1)); k++) {
								pw.println("		" + formselectidlist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvalueidlist.get(k) + '"'
										+ ");");
							}
						}
					}
					for (int j = Integer.parseInt(formselectnamenumber.get(i)); j < formselectnamelist
							.size(); j++) {
						if ((j + 1) == formselectvaluenamenumber.size()) {
							for (int k = Integer
									.parseInt(formselectvaluenamenumber.get(j)); k < formselectvaluenamelist
									.size(); k++) {
								pw.println("		" + formselectnamelist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvaluenamelist.get(k) + '"'
										+ ");");
							}
						} else {
							for (int k = Integer
									.parseInt(formselectvaluenamenumber.get(j)); k < Integer
									.parseInt(formselectvaluenamenumber
											.get(j + 1)); k++) {
								pw.println("		" + formselectnamelist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvaluenamelist.get(k) + '"'
										+ ");");
							}
						}
					}
					if(formsubmitlist.get(i) == null){
						pw.println("/// someElement.submit(); ");
					}else{
						String[] strspl = formsubmitlist.get(i).split("\\.");
						pw.println("		" + strspl[1] + ".submit();");
					}
				} else {
					for (int j = Integer.parseInt(formclickidnumber.get(i)); j < Integer
							.parseInt(formclickidnumber.get(i + 1)); j++) {
						pw.println("		" + formclickidList.get(j) + ".click();");
					}
					for (int j = Integer.parseInt(formclicknamenumber.get(i)); j < Integer
							.parseInt(formclicknamenumber.get(i + 1)); j++) {
						pw.println("		" + formclicknamelist.get(j)
								+ ".click();");
					}
					for (int j = Integer.parseInt(formsendkeysidnumber.get(i)); j < Integer
							.parseInt(formsendkeysidnumber.get(i + 1)); j++) {
						pw.println("		" + formsendkeysidlist.get(j)
								+ ".sendKeys(\"HogeHoge\");");
					}
					for (int j = Integer
							.parseInt(formsendkeysnamenumber.get(i)); j < Integer
							.parseInt(formsendkeysnamenumber.get(i + 1)); j++) {
						pw.println("		" + formsendkeysnamelist.get(j)
								+ ".sendKeys(\"HogeHoge\");");
					}
					for (int j = Integer.parseInt(formselectidnumber.get(i)); j < Integer
							.parseInt(formselectidnumber.get(i + 1)); j++) {
						if ((j + 1) == formselectvalueidnumber.size()) {
							for (int k = Integer
									.parseInt(formselectvalueidnumber.get(j)); k < formselectvalueidlist
									.size(); k++) {
								pw.println("		" + formselectidlist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvalueidlist.get(k) + '"'
										+ ");");
							}
						} else {
							for (int k = Integer
									.parseInt(formselectvalueidnumber.get(j)); k < Integer
									.parseInt(formselectvalueidnumber
											.get(j + 1)); k++) {
								pw.println("		" + formselectidlist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvalueidlist.get(k) + '"'
										+ ");");
							}
						}
					}
					for (int j = Integer.parseInt(formselectnamenumber.get(i)); j < Integer
							.parseInt(formselectnamenumber.get(i + 1)); j++) {
						if ((j + 1) == formselectvaluenamenumber.size()) {
							for (int k = Integer
									.parseInt(formselectvaluenamenumber.get(j)); k < formselectvaluenamelist
									.size(); k++) {
								pw.println("		" + formselectnamelist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvaluenamelist.get(k) + '"'
										+ ");");
							}
						} else {
							for (int k = Integer
									.parseInt(formselectvaluenamenumber.get(j)); k < Integer
									.parseInt(formselectvaluenamenumber
											.get(j + 1)); k++) {
								pw.println("		" + formselectnamelist.get(j)
										+ ".selectByValue(" + '"'
										+ formselectvaluenamelist.get(k) + '"'
										+ ");");
							}
						}
					}
					if(formsubmitlist.get(i) == null){
						pw.println("/// someElement.submit(); ");
					}else{
						String[] strspl = formsubmitlist.get(i).split("\\.");
						pw.println("		" + strspl[1] + ".submit();");
					}
				}
				if (formactionlist.get(i).equals("$PHP_SELF")) {
					pw.println("		return new " + filename + "(driver);\n"
							+ "	}\n");
				} else if (returnIdClass == null) {
					pw.println("		return new InputPageClass(driver);\n"
							+ "	}\n");
				} else {
					pw.println("		return new " + returnIdClass + "(driver);\n"
							+ "	}\n");
				}
			}

		}
	}

	public void writeimport(PrintWriter pw) {
		pw.println("import static org.hamcrest.Matchers.is;\n"
				+ "import static org.junit.Assert.*;\n"
				+ "import static jp.ac.waseda.cs.washi.assertion.Assertion.*;\n"
				+ "import org.openqa.selenium.WebDriver;\n"
				+ "import org.openqa.selenium.WebElement;\n"
				+ "import org.openqa.selenium.support.ui.Select;\n"
				+ "import org.openqa.selenium.support.FindBy;\n"
				+ "import jp.ac.waseda.cs.washi.automake.AbstractPage;\n");
	}

	private static void writePackage(PrintWriter pw, String packageName)
			throws IOException {
		pw.println("package " + packageName + ";\n");
	}

	public void writeLinkMethod(PrintWriter pw, List<String> idList,
			List<String> nameList, List<String> idhrefList,
			List<String> namehrefList) throws Exception {

		for (int i = 0; i < idList.size(); i++) {
			String returnIdClass = null;
			for (int j = 0; j < poPageUrlLists.size(); j++) {
				if (poPageUrlLists.get(j).endsWith(idhrefList.get(i))) {
					returnIdClass = poPageNameLists.get(j);
				}
			}
			if (returnIdClass == null) {
				pw.println("	public InputPageClass go" + idList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ idList.get(i) + ".click();\n"
						+ "		return new InputPageClass(driver);\n" + "	}\n");
			} else {
				pw.println("	public " + returnIdClass + " go" + idList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ idList.get(i) + ".click();\n" + "		return new "
						+ returnIdClass + "(driver);\n" + "	}\n");
			}
		}
		for (int i = 0; i < nameList.size(); i++) {
			String returnNameClass = null;
			for (int j = 0; j < poPageUrlLists.size(); j++) {
				if (poPageUrlLists.get(j).endsWith(namehrefList.get(i))) {
					returnNameClass = poPageNameLists.get(j);
				}
			}
			if (returnNameClass == null) {
				pw.println("	public InputPageClass go" + nameList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ nameList.get(i) + ".click();\n"
						+ "		return new InputPageClass(driver);\n" + "	}\n");
			} else {
				pw.println("	public " + returnNameClass + " go"
						+ nameList.get(i)
						+ "() throws ClassNotFoundException {\n" + "		"
						+ nameList.get(i) + ".click();\n" + "		return new "
						+ returnNameClass + "(driver);\n" + "	}\n");
			}
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
			List<String> nameList, List<String> formclickidList,
			List<String> formclicknameList, List<String> formsendkeysidList,
			List<String> formsendkeysnameList, List<String> formselectidList,
			List<String> formselectnameList, List<String> formsubmitList) {
		for (String id : idList) {
			pw.println("	@FindBy(id =  " + '"' + id + '"' + ")\n"
					+ "	public WebElement " + id + ";\n");
		}
		for (String formclickid : formclickidList) {
			pw.println("	@FindBy(id =  " + '"' + formclickid + '"' + ")\n"
					+ "	public WebElement " + formclickid + ";\n");
		}
		for (String formsendid : formsendkeysidList) {
			pw.println("	@FindBy(id =  " + '"' + formsendid + '"' + ")\n"
					+ "	public WebElement " + formsendid + ";\n");
		}
		for (String name : nameList) {
			pw.println("	@FindBy(name =  " + '"' + name + '"' + ")\n"
					+ "	public WebElement " + name + ";\n");
		}
		for (String formclickname : formclicknameList) {
			pw.println("	@FindBy(name =  " + '"' + formclickname + '"' + ")\n"
					+ "	public WebElement " + formclickname + ";\n");
		}
		for (String formsendname : formsendkeysnameList) {
			pw.println("	@FindBy(name =  " + '"' + formsendname + '"' + ")\n"
					+ "	public WebElement " + formsendname + ";\n");
		}
		for (String formselectid : formselectidList) {
			pw.println("	@FindBy(id =  " + '"' + formselectid + '"' + ")\n"
					+ "	public Select " + formselectid + ";\n");
		}
		for (String formselectname : formselectnameList) {
			pw.println("	@FindBy(name =  " + '"' + formselectname + '"' + ")\n"
					+ "	public Select " + formselectname + ";\n");
		}
		for (int i = 0; i < formsubmitList.size(); i++) {
			if (formsubmitList.get(i) != null) {
				String[] strspl = formsubmitList.get(i).split("\\.");
				if (strspl[0].equals("id")) {
					pw.println("	@FindBy(id =  " + '"' + strspl[1] + '"'
							+ ")\n" + "	public WebElement " + strspl[1] + ";\n");
				} else if (strspl[0].equals("name")) {
					pw.println("	@FindBy(name =  " + '"' + strspl[1] + '"'
							+ ")\n" + "	public WebElement " + strspl[1] + ";\n");
				}else if (strspl[0].equals("value")) {
					pw.println("	@FindBy(css =  " + '"' + "input[value = " + '\\' + '"' + strspl[1] + '\\' + '"' + "]" + '"'
							+ ")\n" + "	public WebElement " + strspl[1] + ";\n");
				}
			}
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
