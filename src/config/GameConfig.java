package config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	
	private int width;
	private int height;
	private int padding;
	private int windowSize;
	private String title;
	private int windowUp;
	
	private List<LayerConfig> layers=new ArrayList<>();
	
	public String getTitle() {
		return title;
	}



	public int getWindowUp() {
		return windowUp;
	}



	public int getWidth() {
		return width;
	}



	public int getHeight() {
		return height;
	}



	public int getPadding() {
		return padding;
	}



	public int getWindowSize() {
		return windowSize;
	}



	public List<LayerConfig> getLayers() {
		return layers;
	}



	public GameConfig() throws DocumentException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read("config/cfg.xml");
		Element game=doc.getRootElement();
		this.setUiConfig(game.element("frame"));
		this.setSystemConfig(game.element("system"));
		this.setDataConfig(game.element("data"));		
		
	}
	
	

	private void setUiConfig(Element frame) {
		this.width=Integer.parseInt(frame.attributeValue("width"));
		this.height=Integer.parseInt(frame.attributeValue("height"));
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		this.title=frame.attributeValue("title");
		this.windowUp=Integer.parseInt(frame.attributeValue("windowUp"));
		
		List<Element> eles=frame.elements();
		for(Element e:eles) {
			LayerConfig layer=new LayerConfig(Integer.parseInt(e.attributeValue("x")),Integer.parseInt(e.attributeValue("y")),
					Integer.parseInt(e.attributeValue("w")),Integer.parseInt(e.attributeValue("h")),
					e.attributeValue("className"));	
			layers.add(layer);
		}	
	}

	private void setSystemConfig(Element system) {
		// TODO Auto-generated method stub
		
	}

	

	/**
	 * 下落类型的数据
	 */
	List<List<Integer>> dropTypeData=new ArrayList<>(7);	
	public List<List<Integer>> getDropTypeData() {
		return dropTypeData;
	}
	/**
	 * 提取下落类型所需要的数据
	 * @param data
	 */
	private void setDataConfig(Element data) {
		Element types=data.element("types");		
		List<Element> type=types.elements();
		for(Element t:type) {
			List<Integer> d=new ArrayList<>(8);
 			for(Element ele:(List<Element>)t.elements()) {
				d.add(Integer.parseInt(ele.attributeValue("x")));
				d.add(Integer.parseInt(ele.attributeValue("y")));
			}
 			dropTypeData.add(d);
		}
	}
	
//	public static void main(String[] args) throws DocumentException {
//		System.out.println("开始");
//		
//		List<List<Integer>> drop=new GameConfig().dropTypeData;		
//		for(List<Integer> list:drop) {
//			for(Integer d:list) {
//				System.out.print(d+" ");
//			}
//			System.out.println();
//		}
//	}
}
