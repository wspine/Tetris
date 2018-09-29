package entity;

import java.awt.Point;

public class DropType {

	
	private Point[] actPoints;
	
	public DropType() {
		actPoints=new Point[] {
		new Point(3, 0),
		new Point(4, 0),
		new Point(5, 0),
		new Point(5, 1)		
		};
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	
}
