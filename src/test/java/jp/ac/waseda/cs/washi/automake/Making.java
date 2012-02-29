package jp.ac.waseda.cs.washi.automake;

import java.util.ArrayList;
import java.util.List;

public class Making {

	private List<String> poPackageName = new ArrayList<String>();
	private List<String> poDirectory = new ArrayList<String>();
	private List<String> poPageNameLists = new ArrayList<String>();
	private List<String> poPageUrlLists = new ArrayList<String>();
	private List<String> poNumberOfPage = new ArrayList<String>();
	private List<String> poNumberOfPO = new ArrayList<String>();
	private List<String> tcPackageName = new ArrayList<String>();
	private List<String> tcPackageNameforPO = new ArrayList<String>();
	private List<String> tcDirectory = new ArrayList<String>();
	private List<String> tcNameLists = new ArrayList<String>();
	private List<String> tcNumberOfTC = new ArrayList<String>();
	private List<String> tcNumberOfTCs = new ArrayList<String>();
	private List<List<String>> PO = new ArrayList<List<String>>();
	private List<List<String>> TC = new ArrayList<List<String>>();

	public void makepages(String url) throws Exception {

		Parseconfig pc = new Parseconfig();
		List<List<List<String>>> configset = pc.Parsing(url);
		PO = configset.get(0);
		TC = configset.get(1);
		poPackageName = PO.get(0);
		poDirectory = PO.get(1);
		poPageNameLists = PO.get(2);
		poPageUrlLists = PO.get(3);
		poNumberOfPage = PO.get(4);
		poNumberOfPO = PO.get(5);
		tcPackageName = TC.get(0);
		tcPackageNameforPO = TC.get(1);
		tcDirectory = TC.get(2);
		tcNameLists = TC.get(3);
		tcNumberOfTC = TC.get(4);
		tcNumberOfTCs = TC.get(5);

		for (int i = 0; i < Integer.parseInt(poNumberOfPO.get(0)); i++) {
			makePOs(Integer.parseInt(poNumberOfPage.get(i)), i);
		}
		for (int i = 0; i < Integer.parseInt(tcNumberOfTCs.get(0)); i++) {
			makeTCs(Integer.parseInt(tcNumberOfTC.get(0)), i);
		}
	}

	private void makeTCs(int numberOfTC, int tcNumber) throws Exception {
		for (int i = 0; i < numberOfTC; i++) {
			MakeTestCaseSkeletonFile fl = new MakeTestCaseSkeletonFile();
			String namesAndAddress[] = fl.makeSkeleton(tcNameLists.get(i),
					tcDirectory.get(tcNumber), tcPackageName.get(tcNumber),
					tcPackageNameforPO.get(tcNumber));
			WriteTestCase wtc = new WriteTestCase();
			wtc.writeTest(namesAndAddress);
		}
	}

	private void makePOs(int numberOfPage, int poNumber) throws Exception {
		for (int i = 0; i < numberOfPage; i++) {
			MakePageObjectFile fl = new MakePageObjectFile();
			String nameAndAddress[] = fl.makeFile(poPageNameLists.get(i),
					poDirectory.get(poNumber), poPackageName.get(poNumber));
			List<List<String>> idList = new ArrayList<List<String>>();
			GetIdwithNekoHTML neko = new GetIdwithNekoHTML();
			idList = neko.getId(poPageUrlLists.get(i));
			WritePage wp = new WritePage(idList, poDirectory.get(poNumber),
					poPageNameLists, poPageUrlLists);
			wp.write(nameAndAddress);
		}
	}
}
