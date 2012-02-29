package jp.ac.waseda.cs.washi.automake;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Parseconfig{
	
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
	private List<List<List<String>>> configset = new ArrayList<List<List<String>>>();

    public List<List<List<String>>> Parsing(String parseurl) throws Exception {
        final URL url = new URL("file:" + parseurl);
        final URLConnection urlConnection = url.openConnection();
        final DOMParser parser = new DOMParser();
        final InputStream is = urlConnection.getInputStream();
        try {
            parser.parse(new InputSource(is));
            final Document doc = parser.getDocument();
            final Element root = doc.getDocumentElement();
            walkTree("", root);
        }
        finally {
            is.close();
        }
        PO.add(poPackageName);
        PO.add(poDirectory);
        PO.add(poPageNameLists);
        PO.add(poPageUrlLists);
        PO.add(poNumberOfPage);
        PO.add(poNumberOfPO);
        TC.add(tcPackageName);
        TC.add(tcPackageNameforPO);
        TC.add(tcDirectory);
        TC.add(tcNameLists);
        TC.add(tcNumberOfTC);
        TC.add(tcNumberOfTCs);
        configset.add(PO);
        configset.add(TC);
        return configset;
    }
    
    private void walkTree(final String level,final Element elm) throws Exception {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equals("PAGEOBJECTS")){
                    	walkTreePOs(level + " ", (Element) child);
                    }else if(element.getTagName().equals("TESTCASES")){
                    	walkTreeTCs(level + " ", (Element) child);
                    }else{
                    	walkTree(level + " ", (Element) child);
                    }
                }
            }
        }
    }

	private void walkTreeTCs(final String level, final Element elm) {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            tcNumberOfTCs.add(String.valueOf(len/2));
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equals("TESTCASE")){
                    	walkTreeTC(level + " ", (Element) child);
                    }else{
                    	walkTreeTCs(level + " ", (Element) child);
                    }
                }
            }
        }
	}

	private void walkTreeTC(final String level,final Element elm) {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equals("TESTLISTS")){
                    	walkTreeTestList(level + " ", (Element) child);
                    }else if(element.getTagName().equals("DIRECTORY")){
                    	tcDirectory.add(child.getChildNodes().item(0).getTextContent());
                    }else if(element.getTagName().equals("TESTPACKAGENAME")){
                    	tcPackageName.add(child.getChildNodes().item(0).getTextContent());
                    }else if(element.getTagName().equals("POPACKAGENAME")){
                    	tcPackageNameforPO.add(child.getChildNodes().item(0).getTextContent());
                    }else{
                    	walkTreeTC(level + " ", (Element) child);
                    }
                }
            }
        }
	}

	private void walkTreeTestList(final String level, final Element elm) {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            tcNumberOfTC.add(String.valueOf(len/2));
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equals("TEST")){
                    	tcNameLists.add(child.getChildNodes().item(0).getTextContent());
                    }else{
                    	walkTreeTestList(level + " ", (Element) child);
                    }
                }
            }
        }
	}

	private void walkTreePOs(final String level,final Element elm) {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            poNumberOfPO.add(String.valueOf(len/2));
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equals("PAGEOBJECT")){
                    	walkTreePO(level + " ", (Element) child);
                    }else{
                    	walkTreePOs(level + " ", (Element) child);
                    }
                }
            }
        }
	}

	private void walkTreePO(final String level,final Element elm) {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equals("PAGELISTS")){
                    	walkTreePageLists(level + " ", (Element) child);
                    }else if(element.getTagName().equals("DIRECTORY")){
                    	poDirectory.add(child.getChildNodes().item(0).getTextContent());
                    }else if(element.getTagName().equals("PACKAGENAME")){
                    	poPackageName.add(child.getChildNodes().item(0).getTextContent());
                    }else{
                    	walkTreePO(level + " ", (Element) child);
                    }
                }
            }
        }
	}

	private void walkTreePageLists(final String level,final Element elm) {
		final NodeList children = elm.getChildNodes();
		if (children != null) {
			final int len = children.getLength();
			poNumberOfPage.add(String.valueOf(len/2));
			for (int idx = 0; idx < len; idx++) {
				final Node child = (Node) children.item(idx);
				if (child.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) child;
					if(element.getTagName().equals("PAGE")){
						walkTreePage(level + " ", (Element) child);
					}else{
						walkTreePageLists(level + " ", (Element) child);
					}
				}
			}
		}
	}

	private void walkTreePage(final String level, final Element elm) {
		final NodeList children = elm.getChildNodes();
		if (children != null) {
			final int len = children.getLength();
			for (int idx = 0; idx < len; idx++) {
				final Node child = (Node) children.item(idx);
				if (child.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) child;
					if(element.getTagName().equals("NAME")){
						poPageNameLists.add(child.getChildNodes().item(0).getTextContent());
					}else if(element.getTagName().equals("URL")){
						poPageUrlLists.add(child.getChildNodes().item(0).getTextContent());
					}else{
						walkTreePage(level + " ", (Element) child);
					}
				}
			}
		}		
	}
}