package jp.ac.waseda.cs.washi.nekohtml_test;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class nekoHTML_test {
	
	public static void main(final String[] args) throws Exception{
		final URL url = new URL("http://www.yahoo.co.jp/");
		final URLConnection urlConnection = url.openConnection();
		final DOMParser parser = new DOMParser();
		final InputStream is = urlConnection.getInputStream();
		try{
			parser.parse(new InputSource(is));
			final Document doc = parser.getDocument();
			final Element root = doc.getDocumentElement();
			walkTree("",root);
		}finally{
			is.close();
		}

		

	}

	private static void walkTree(final String level, final Element elm) {
		//System.out.println(level + "<" + elm.getTagName() + ">");
		final NodeList children = elm.getChildNodes();
		if(children != null){
			final int len = children.getLength();
			for(int idx = 0; idx < len; idx++){
				final Node child = (Node) children.item(idx);
				if(child.getNodeType() == Node.ELEMENT_NODE){
					walkTree(level + "", (Element)child);
					Element element = (Element) child;
					if(null != element.getAttributes().getNamedItem("id") && null != element.getAttributes().getNamedItem("href")){
						System.out.println(element.getAttributes().getNamedItem("id"));
					}
					
				}
				else if(child.getNodeType() == Node.TEXT_NODE){
					final String txt = child.getNodeValue();
					if(txt.trim().length() > 0){
					//	System.out.println(level + txt);
					}
				}
			}
		}
	}

}
