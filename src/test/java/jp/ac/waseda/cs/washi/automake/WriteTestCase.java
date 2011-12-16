package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteTestCase {

	public void writeTest(String[] names) {
		try {
			File file = new File(names[1]);
			
			if(checkBeforeWriteFile(file)){
				input(file, names);
			}else{
				System.out.println("書き込みできません");
			}
		} catch (Exception e) {
			System.out.println("ファイル書き込みミス");
		}
		
	}

	private void input(File file, String[] names) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			writePackage(pw,names[0]);
			
			writeimport(pw, names[3]);
			
			writeClass(pw, names[2]);
			
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeClass(PrintWriter pw, String className) {
		pw.println("public class " + className + " {\n");
		
		pw.println("	private static FirefoxDriver driver;\n");
		
		writeBefore(pw);
		
		writeAfter(pw);
		
		writeTest(pw,className);
		
		pw.println("}");
		
	}

	private void writeTest(PrintWriter pw, String className) {
		pw.println("	@Test\n" +
				"	public void do" + className + "() throws SecurityException,\n" +
				"	IllegalArgumentException, NoSuchMethodException,\n" +
				"	IllegalAccessException, InvocationTargetException,\n" +
				"	ClassNotFoundException, InstantiationException  {\n" +
				"		Starter st = new Starter(driver);\n" +
				"		st/*.goHogeHoge()\n" +
				"			.goChomeChome()\n" +
				"			.doAssert(new AssertFunction<InputNowPage>() {\n" +
				"				@Override\n" +
				"				public void assertPage(InputNowPage page) {\n" +
				"					assertNotNull(page.hoge);\n" +
				"				}\n" +
				"			})\n" +
				"			.doUnEx(new UnExpectAction<InputNowPage,InputNextPage>() {\n" +
				"				@Override\n" +
				"				public <T> InputNextPage unExpectAct(InputNowPage page)throws ClassNotFoundException {\n" +
				"					assertNotNull(page.hoge);\n" +
				"					page.chome.click();\n" +
				"					return new InputNextPage(driver);\n" +
				"				}\n" +
				"			})\n" +
				"			.goSomewhare(String)*/;\n" +
				"	}\n");
	}

	private void writeAfter(PrintWriter pw) {
		pw.println("	@AfterClass\n" +
				"	public static void tearDownAfterClass() throws Exception {\n" +
				"		driver.quit();\n" +
				"	}\n");
	}

	private void writeBefore(PrintWriter pw) {
		pw.println("	@BeforeClass\n" +
				"	public static void setUpBeforeClass() throws Exception {\n" +
				"		driver = new FirefoxDriver();\n" +
				"		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);\n" +
				"	}\n");		
	}

	private void writeimport(PrintWriter pw, String pagePackageName) {
		pw.println("import java.util.concurrent.TimeUnit;\n" +
				"import java.lang.reflect.InvocationTargetException;\n");
		pw.println("import static org.junit.Assert.*;\n" +
				"import static org.hamcrest.Matchers.is;\n");
		pw.println("import " + pagePackageName + ".*;\n" +
				"import org.junit.AfterClass;\n" +
				"import org.junit.BeforeClass;\n" +
				"import org.junit.Test;\n" +
				"import org.openqa.selenium.firefox.FirefoxDriver;\n");
	}

	private void writePackage(PrintWriter pw, String testPackageName) {
		pw.println("package " + testPackageName + ";\n");
		
	}

	private boolean checkBeforeWriteFile(File file) {
		if(file.exists()){
			if(file.isFile() && file.canWrite()){
				return true;
			}
		}
		return false;
	}

}
