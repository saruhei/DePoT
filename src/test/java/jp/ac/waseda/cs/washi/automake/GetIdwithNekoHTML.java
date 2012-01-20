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
	private int formselectId;
	private int formselectName;
	private int formselectvalueId;
	private int formselectvalueName;
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
	private List<String> formSelectIdLists = new ArrayList<String>();
	private List<String> formSelectNameLists = new ArrayList<String>();
	private List<String> formSelectIdNumber = new ArrayList<String>();
	private List<String> formSelectNameNumber = new ArrayList<String>();
	private List<String> formSelectValueIdLists = new ArrayList<String>();
	private List<String> formSelectValueNameLists = new ArrayList<String>();
	private List<String> formSelectValueIdNumber = new ArrayList<String>();
	private List<String> formSelectValueNameNumber = new ArrayList<String>();
	private List<String> formSubmitLists = new ArrayList<String>();
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
			formselectId = 0;
			formselectName = 0;
			formselectvalueId = 0;
			formselectvalueName = 0;
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
		methodNames.add(formSelectIdLists);
		methodNames.add(formSelectNameLists);
		methodNames.add(formSelectIdNumber);
		methodNames.add(formSelectNameNumber);
		methodNames.add(formSelectValueIdLists);
		methodNames.add(formSelectValueNameLists);
		methodNames.add(formSelectValueIdNumber);
		methodNames.add(formSelectValueNameNumber);
		methodNames.add(formSubmitLists);
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
					if(element.getTagName().equalsIgnoreCase("FORM")){
						System.out.println(element.getAttribute("action"));
						formActionLists.add(element.getAttribute("action"));
                    	formSubmitLists.add(null);
						formclickIdNumber.add(String.valueOf(formclickId));
						formclickNameNumber.add(String.valueOf(formclickName));
						formsendkeysIdNumber.add(String.valueOf(formsendkeysId));
						formsendkeysNameNumber.add(String.valueOf(formsendkeysName));
						formSelectIdNumber.add(String.valueOf(formselectId));
						formSelectNameNumber.add(String.valueOf(formselectName));
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
                    if(element.getAttribute("type").equalsIgnoreCase("TEXT") || element.getAttribute("type").equalsIgnoreCase("PASSWORD")
                    		|| element.getAttribute("type").equalsIgnoreCase("FILE") || element.getTagName().equalsIgnoreCase("TEXTAREA")){
                    	if(null != element.getAttributes().getNamedItem("id")){
                    		formsendkeysIdLists.add(element.getAttribute("id"));
                    		formsendkeysId = formsendkeysId + 1;
                    	}else if(null != element.getAttributes().getNamedItem("name")){
                    		formsendkeysNameLists.add(element.getAttribute("name"));
                    		formsendkeysName = formsendkeysName + 1;
                    	}else{
                    		walkTreeForm(level + " ", (Element) child);
                    	}
                    }else if(element.getAttribute("type").equalsIgnoreCase("SUBMIT")){
                    	System.out.println(element.getAttribute("value"));
                    	if(null != element.getAttributes().getNamedItem("id")){
                    		formSubmitLists.set((formActionLists.size()) - 1, "id."+element.getAttribute("id"));
                    	}else if(null != element.getAttributes().getNamedItem("name")){
                    		formSubmitLists.set((formActionLists.size()) - 1, "name."+element.getAttribute("name"));
                    	}else if(null != element.getAttributes().getNamedItem("value")){
                    		formSubmitLists.set((formActionLists.size()) - 1, "value."+element.getAttribute("value"));
                    	}else{
                    		walkTreeForm(level + " ", (Element) child);
                    	}
                    }else if(element.getAttribute("type").equalsIgnoreCase("RADIO") || element.getAttribute("type").equalsIgnoreCase("CHECKBOX")
                    		|| element.getAttribute("type").equalsIgnoreCase("IMAGE") || element.getAttribute("type").equalsIgnoreCase("BUTTON")
                    		|| element.getTagName().equalsIgnoreCase("BUTTON")){
                    	if(null != element.getAttributes().getNamedItem("id")){
                    		formclickIdLists.add(element.getAttribute("id"));
                    		formclickId = formclickId +1;
                    	}else if(null != element.getAttributes().getNamedItem("name")){
                    		formclickNameLists.add(element.getAttribute("name"));
                    		formclickName = formclickName + 1;
                    	}else{
                    		walkTreeForm(level + " ", (Element) child);
                    	}
                    }else if(element.getTagName().equalsIgnoreCase("SELECT")){
                    	if(null != element.getAttributes().getNamedItem("id")){
                    		formSelectIdLists.add(element.getAttribute("id"));
                    		formselectId = formselectId +1;
                        	walkTreeSelect(level + " ", (Element) child , "id");
                    	}else if(null != element.getAttributes().getNamedItem("name")){
                    		formSelectNameLists.add(element.getAttribute("name"));
                    		formselectName = formselectName + 1;
                        	walkTreeSelect(level + " ", (Element) child, "name");
                    	}else{
                    		walkTreeForm(level + " ", (Element) child);
                    	}
                    }else{
                    	walkTreeForm(level + " ", (Element) child);
                    }
                }
            }
        }
	}

	private void walkTreeSelect(final String level,final Element elm, String version) {
        final NodeList children = elm.getChildNodes();
        if(version.equalsIgnoreCase("name")){
        	formSelectValueNameNumber.add(String.valueOf(formselectvalueName));
        }else if(version.equalsIgnoreCase("id")){
    		formSelectValueIdNumber.add(String.valueOf(formselectvalueId));
        }
        if (children != null) {
            final int len = children.getLength();
            for (int idx = 0; idx < len; idx++) {
                final Node child = (Node) children.item(idx);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) child;
                    if(element.getTagName().equalsIgnoreCase("OPTION")){
                    	if(null != element.getAttributes().getNamedItem("value")){
                           	if(version.equalsIgnoreCase("id")){
                            	formSelectValueIdLists.add(element.getAttribute("value"));
                            	formselectvalueId = formselectvalueId + 1;
                        	}else if(version.equalsIgnoreCase("name")){
                            	formSelectValueNameLists.add(element.getAttribute("value"));
                            	formselectvalueName = formselectvalueName + 1;
                        	}
                    	}
                    }else{
                    	walkTreeSelect(level + " ", (Element) child, version);
                    }
                }
            }
        }
	}

}
