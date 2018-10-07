package dto;

import java.awt.Point;
import java.util.List;

import entity.DropType;


/**
 * 简单单对象
 * @author Administrator
 *
 */
public class GameDto {

	private List<Player> dbRecode;
	private List<Player> diskRecode;
	
	/**
	 * 堆积矩阵
	 */
	private boolean[][] stackedMap=new boolean[10][18]; 
	/**
	 * 下落形状
	 */
	private DropType dropType; 
	/**
	 * 下一个形状编号
	 */
	private int next;
	/**
	 * 等级
	 */
	private int level;
	/**
	 * 当前分数
	 */
	private int nowPoint;
	/**
	 * 当前移除的行数
	 */
	private int nowRemoveLine;
	
	/**
	 * 将下落的到底部的类型的数据帮定到map
	 */
	public void dropTypeBindInMap() {
		Point[] ps=this.dropType.getActPoints();
		for (int i = 0; i < ps.length; i++) {			
			stackedMap[ps[i].x][ps[i].y]=true;
		}
	}
	

	/**
	 * 判断是否可以进行下落操作
	 * @return
	 */
	public boolean isReachBottom() {
		Point[] ps=this.dropType.getActPoints();
		for(int i=0;i<ps.length;i++) {			
			//TODO  触碰到地图是也不能移动
			if(ps[i].y+1>17||this.stackedMap[ps[i].x][ps[i].y+1]) return true;			
		}
		return false;	
	}
	
	
	
	
	public List<Player> getDbRecode() {
		return dbRecode;
	}
	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = dbRecode;
	}
	public List<Player> getDiskRecode() {
		return diskRecode;
	}
	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = diskRecode;
	}
	
	public boolean[][] getStackedMap() {
		return stackedMap;
	}
	public void setStackedMap(boolean[][] stackedMap) {
		this.stackedMap = stackedMap;
	}
	public DropType getDropType() {
		return dropType;
	}
	public void setDropType(DropType dropType) {
		this.dropType = dropType;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNowPoint() {
		return nowPoint;
	}
	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}
	public int getNowRemoveLine() {
		return nowRemoveLine;
	}
	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
}
