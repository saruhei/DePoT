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

public class GetIdwithNekoHTML {
	
	private int formclickId;
	private int formclickName;
	private int formsendkeysId;
	private int formsendkeysName;
	private List<String> idmethodName = new ArrayList<String>();
	private List<String> idmethodhref = new ArrayList<String>();
	private List<String> namemethodName = new ArrayList<String>();
	private List<String> namemethodhref = new ArrayList<String>();
	private List<String> formActionLists = new ArrayList<String>();
	private List<String> formclickIdLists = new ArrayList<String>();
	private List<String> formclickNameLists = new ArrayList<String>();
	private List<String> formsendkeysIdLists = new ArrayList<String>();
	private List<String> formsendkeysNameLists = new ArrayList<String>();
	private List<String> formclickIdNumber = new ArrayList<String>();
	private List<String> formclickNameNumber = new ArrayList<String>();
	private List<String> formsendkeysIdNumber = new ArrayList<String>();
	private List<String> formsendkeysNameNumber = new ArrayList<String>();
	private List<String> formSelectLists = new ArrayList<String>();
	private List<List<String>> methodNames = new ArrayList<List<String>>();

	public List<List<String>> getId(String getscan) throws Exception {
		String urladdresss = getscan;
		final URL url = new URL(urladdresss);
		final URLConnection urlConnection = url.openConnection();
		final DOMParser parser = new DOMParser();
		final InputStream is = urlConnection.getInputStream();
		try {
			formclickId = 0;
			formclickName = 0;
			formsendkeysId = 0;
			formsendkeysName = 0;
			parser.parse(new InputSource(is));
			final Document doc = parser.getDocument();
			final Element root = doc.getDocumentElement();
			walkTree("", root);
		} finally {
			is.close();
		}
		methodNames.add(idmethodName);
		methodNames.add(namemethodName);
		methodNames.add(idmethodhref);
		methodNames.add(namemethodhref);
		methodNames.add(formActionLists);
		methodNames.add(formclickIdLists);
		methodNames.add(formclickNameLists);
		methodNames.add(formsendkeysIdLists);
		methodNames.add(formsendkeysNameLists);
		methodNames.add(formclickIdNumber);
		methodNames.add(formclickNameNumber);
		methodNames.add(formsendkeysIdNumber);
		methodNames.add(formsendkeysNameNumber);
		methodNames.add(formSelectLists);
		return methodNames;
	}

	private void walkTree(final String level, final Element elm) {
		final NodeList children = elm.getChildNodes();
		if (children != null) {
			final int len = children.getLength();
			for (int idx = 0; idx < len; idx++) {
				final Node child = (Node) children.item(idx);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) child;
					if(element.getTagName().equals("FORM")){
						formActionLists.add(element.getAttribute("action"));
						formclickIdNumber.add(String.valueOf(formclickId));
						formclickNameNumber.add(String.valueOf(formclickName));
						formsendkeysIdNumber.add(String.valueOf(formsendkeysId));
						formsendkeysNameNumber.add(String.valueOf(formsendkeysName));
						walkTreeForm(level + "", (Element) child);
					}else if (((null != element.getAttributes().getNamedItem("id") || null != element
							.getAttributes().getNamedItem("name")))){
						if(null != element.getAttributes().getNamedItem("href")){
							if(null != element.getAttributes().getNamedItem("id")){
								idmethodName.add(element.getAttribute("id"));
								idmethodhref.add(element.getAttribute("href"));
							}else if((null == element.getAttributes().getNamedItem("id")) && (null != element.getAttributes().getNamedItem("name"))){
								namemethodName.add(element.getAttribute("name"));
								namemethodhref.add(element.getAttribute("href"));
							}
							walkTree(level + "", (Element) child);
						}else{
							walkTree(level + "", (Element) child);
						}
					}else{
						walkTree(level + "", (Element) child);
					}

				} else if (child.getNodeType() == Node.TEXT_NODE) {
					final String txt = child.getNodeValue();
					if (txt.trim().length() > 0) {
					}
				}
			}
		}
	}

	private void walkTreeForm(final String level,final Element elm) {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getAttribute("type").equals("TEXT") || element.getAttribute("type").equals("PASSWORD")
                    		|| element.getAttribute("type").equals("FILE") || element.getTagName().equals("TEXTAREA")){
                    	if(null != element.getAttributes().getNamedItem("id")){
                    		formsendkeysIdLists.add(element.getAttribute("id"));
                    		formsendkeysId = formsendkeysId + 1;
                    	}else if(null != element.getAttributes().getNamedItem("name")){
                    		formsendkeysNameLists.add(element.getAttribute("name"));
                    		formsendkeysName = formsendkeysName + 1;
                    	}else{
                    		walkTreeForm(level + " ", (Element) child);
                    	}
                    }else if(element.getAttribute("type").equals("RADIO") || element.getAttribute("type").equals("CHECKBOX")
                    		|| element.getAttribute("type").equals("IMAGE") || element.getAttribute("type").equals("BUTTON")
                    		|| element.getTagName().equals("BUTTON")){
                    	if(null != element.getAttributes().getNamedItem("id")){
                    		formclickIdLists.add(element.getAttribute("id"));
                    		formclickId = formclickId +1;
                    	}else if(null != element.getAttributes().getNamedItem("name")){
                    		formclickNameLists.add(element.getAttribute("name"));
                    		formclickName = formclickName + 1;
                    	}else{
                    		walkTreeForm(level + " ", (Element) child);
                    	}
                    }else if(element.getTagName().equals("SELECT")){
                    	walkTreeSelect(level + " ", (Element) child);
                    }else{
                    	walkTreeForm(level + " ", (Element) child);
                    }
                }
            }
        }
	}

	private void walkTreeSelect(final String level,final Element elm) {
        final NodeList children = elm.getChildNodes();
        if (children != null) {
            final int len = children.getLength();
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equals("OPTION")){
                    	//formSelectLists.add(formclickIdNumber.size(),element.getAttribute("value"));
                    }else{
                    	walkTreeSelect(level + " ", (Element) child);
                    }
                }
            }
        }
	}

}
