package jp.ac.waseda.cs.washi.automake;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ParseDependency {
	
	private String returnClass;

	public String parsedepend(String string, String diraddress) throws Exception {
		File dir = new File(diraddress);
		String dirname = dir.getName();
		String urladdresss = "file:./src/test/java/jp/ac/waseda/cs/washi/dependency/" + dirname + ".xml";
		final URL url = new URL(urladdresss);
		final URLConnection urlConnection = url.openConnection();
		final DOMParser parser = new DOMParser();
		final InputStream is = urlConnection.getInputStream();
		try {
			parser.parse(new InputSource(is));
			final Document doc = parser.getDocument();
			final Element root = doc.getDocumentElement();
			walkTree("", root,string);
		} finally {
			is.close();
		}
		return returnClass;
	}
	
	private void walkTree(final String level, final Element elm, String string) {
		final NodeList children = elm.getChildNodes();
		if (children != null) {
			final int len = children.getLength();
			for (int idx = 0; idx < len; idx++) {
				final Node child = (Node) children.item(idx);
				if (child.getNodeType() == Node.ELEMENT_NODE) {
					walkTree(level + "", (Element) child, string);
					Element element = (Element) child;
					//System.out.println(element.getAttribute("Page"));
					if((element.getAttribute("href")).endsWith(string)){
						returnClass = element.getAttribute("Page");
						//System.out.println(element.getAttribute("Page"));
					}

				} else if (child.getNodeType() == Node.TEXT_NODE) {
					final String txt = child.getNodeValue();
					if (txt.trim().length() > 0) {
					}
				}
			}
		}
	}

}
