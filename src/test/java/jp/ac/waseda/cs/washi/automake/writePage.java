package jp.ac.waseda.cs.washi.automake;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class writePage {
	
	private List<String> idList = new ArrayList<String>();
	
	public writePage(List<String> idList){
		this.idList = idList;
	}
	
	public void write(String[] pNaD){
		try {
			File file = new File(pNaD[1]);
			
			if(checkBeforeWriteFile(file)){
				
				input(file,pNaD[0],pNaD[2]);

			}else{
				System.out.println("ファイル書き込みミス");
			}
			
		} catch (Exception e) {
			System.out.println("書き込みミス");
		}
	}

	public void input(File file, String packagename, String filename) {
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			writePackage(pw,packagename);
			
			writeimport(pw);
			
			writeClass(pw,filename);
			
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeClass(PrintWriter pw, String string) {
		pw.println("public class " + string + " extends AbstractPage {\n");
		
		writeFindBy(pw, idList);
		
		writeConstructor(pw,string);
		
		writeAssertInvariant(pw);
		
		writeMethod(pw,idList);
		
		pw.println("}");
	}

	public void writeimport(PrintWriter pw) {
		pw.println("import static org.hamcrest.Matchers.is;\n" +
				"import static org.junit.Assert.assertThat;\n" +
				"import org.openqa.selenium.WebDriver;\n" +
				"import org.openqa.selenium.WebElement;\n" +
				"import org.openqa.selenium.support.FindBy;\n");
	}

	private static void writePackage(PrintWriter pw, String packageName) throws IOException {
		pw.println("package " + packageName +";\n");	
	}

	public void writeMethod(PrintWriter pw, List<String> idList) {
		
		for(int i = 0; i < idList.size(); i++){
			pw.println("	public HogeHoge " + idList.get(i) + "() throws ClassNotFoundException {\n" +
					"		" + idList.get(i) + ".click();\n" +
					"		return new HogeHoge(driver);\n" +
					"	}\n");
		}	
	}

	public void writeAssertInvariant(PrintWriter pw) {
		pw.println("	@Override\n" +
				"	protected void assertInvariant() {\n" +
				"	}\n");
	}

	public void writeConstructor(PrintWriter pw, String string) {
		pw.println("	private final String keyword;\n");
		pw.println("	public " +string+ "(WebDriver driver, String keyword)\n" +
				"			throws ClassNotFoundException {\n" +
				"		super(driver);\n" +
				"		this.keyword = keyword;\n" +
				"		assertInvariant();\n" +
				"	}\n");	
	}

	public void writeFindBy(PrintWriter pw, List<String> idList) {
		for(int i = 0; i < idList.size(); i++){
			pw.println("	@FindBy(id =  "+'"' + idList.get(i) + '"' + ")\n" +
					"	private WebElement " + idList.get(i) + ";\n");	
		}
	}

	public boolean checkBeforeWriteFile(File file) {
		if(file.exists()){
			if(file.isFile() && file.canWrite()){
				return true;
			}
		}
		return false;
	}

}
