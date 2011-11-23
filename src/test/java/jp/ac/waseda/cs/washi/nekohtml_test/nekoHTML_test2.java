package jp.ac.waseda.cs.washi.nekohtml_test;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class nekoHTML_test2 {
	public static void main(String args[]) throws Exception{
		DOMParser parser = new DOMParser();
		parser.parse("http://oss.infoscience.co.jp/seleniumhq/docs/03_selenium_ide.html");
		Document document = parser.getDocument();
		NodeList nodeList = document.getElementsByTagName("a");
		for(int i = 0; i < nodeList.getLength(); i++){
			Element element = (Element)nodeList.item(i);
			//System.out.println(element.getAttributes().getNamedItem("name"));
			//System.out.println(element.getAttributes().getNamedItem("id"));
			if(null != element.getAttributes().getNamedItem("id") && null != element.getAttributes().getNamedItem("href")){
				System.out.println(element.getAttributes().getNamedItem("id"));
			}
		}
		
	}

}
