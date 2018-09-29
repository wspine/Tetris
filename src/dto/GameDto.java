package dto;

import java.util.List;

import entity.DropType;


/**
 * �򵥵�����
 * @author Administrator
 *
 */
public class GameDto {

	private List<Player> dbRecode;
	private List<Player> diskRecode;
	
	/**
	 * �ѻ�����
	 */
	private boolean[][] stackedSquare=new boolean[18][10]; 
	/**
	 * ������״
	 */
	private DropType dropType; 
	/**
	 * ��һ����״���
	 */
	private int next;
	/**
	 * �ȼ�
	 */
	private int level;
	/**
	 * ��ǰ����
	 */
	private int nowPoint;
	/**
	 * ��ǰ�Ƴ�������
	 */
	private int nowRemoveLine;
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
	public boolean[][] getStackedSquare() {
		return stackedSquare;
	}
	public void setStackedSquare(boolean[][] stackedSquare) {
		this.stackedSquare = stackedSquare;
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
