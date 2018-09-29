package config;

public class LayerConfig {

	private int x;
	private int y;
	private int w;
	private int h;
	private String className;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public String getClassName() {
		return className;
	}
	public LayerConfig(int x, int y, int w, int h, String className) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.className = className;
	}
	
}
