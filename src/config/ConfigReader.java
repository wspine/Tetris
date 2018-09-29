package config;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigReader {

	public static void readConfig() throws DocumentException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read("config/cfg.xml");
		Element game=doc.getRootElement();
		Element frame=game.element("frame");
		List<Element> layers=frame.elements("layer");
		for(Element e:layers) {
			System.out.println(e.attributeValue("className")+" "+e.attributeValue("x")+" "+e.attributeValue("y")+" "
					+e.attributeValue("h")+" "+e.attributeValue("w"));
		}
		String width=frame.attributeValue("width");
		String height=frame.attributeValue("height");
		System.out.println(width+" "+height);
		
	}
}
