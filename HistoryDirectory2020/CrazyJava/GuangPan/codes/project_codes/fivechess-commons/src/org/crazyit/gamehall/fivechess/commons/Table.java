package org.crazyit.gamehall.fivechess.commons;

import java.awt.Rectangle;

/**
 * ��Ϸ�е�һ�����Ӷ���
 * 
 * @author yangenxiong yangenxiong2009@gmail.com
 * @version  1.0
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br>Copyright (C), 2009-2010, yangenxiong
 * <br>This program is protected by copyright laws.
 */
public class Table {

	//�ڽ����еĿ�ʼX����
	private int beginX;
	
	//�ڽ����еĿ�ʼY����
	private int beginY;
	
	//���ӵ�ͼƬ
	private String tableImage;	
	
	//���Ӻ�
	private int tableNumber;
	
	//Ĭ�ϵ�ͼƬ��
	public final static int DEFAULT_IMAGE_WIDTH = 140;
	
	//Ĭ�ϵ�ͼƬ��
	public final static int DEFAULT_IMAGE_HEIGHT = 140;
	
	//��Table��Ӧ�ķ�Χ
	private Rectangle range;
	
	//��ߵ���λ
	private Seat leftSeat;
	
	//�ұߵ���λ
	private Seat rightSeat;
	
	public Table(int beginX, int beginY, int tableNumber) {
		this.beginX = beginX;
		this.beginY = beginY;
		this.tableNumber = tableNumber;
		this.range = new Rectangle(beginX, beginY, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
		//�������Ӷ����ʱ��ʹ������ҵ�Seat����
		this.leftSeat = new Seat(null, new Rectangle(getLeftSeatBeginX(), getLeftSeatBeginY(), 
				Seat.SEAT_WIDTH, Seat.SEAT_HEIGHT), Seat.LEFT);
		this.rightSeat = new Seat(null, new Rectangle(getRightSeatBeginX(), getRightSeatBeginY(), 
				Seat.SEAT_WIDTH, Seat.SEAT_HEIGHT), Seat.RIGHT);
	}

	public int getBeginX() {
		return beginX;
	}

	public void setBeginX(int beginX) {
		this.beginX = beginX;
	}

	public int getBeginY() {
		return beginY;
	}

	public void setBeginY(int beginY) {
		this.beginY = beginY;
	}

	public String getTableImage() {
		return tableImage;
	}

	public void setTableImage(String tableImage) {
		this.tableImage = tableImage;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	//�õ��ұ�����Ŀ�ʼX����
	public int getRightSeatBeginX() {
		return this.beginX + 101;
	}
	
	//�õ��ұ���λ�Ŀ�ʼY����
	public int getRightSeatBeginY() {
		return this.beginY + 52;
	}

	//�õ������λ�Ŀ�ʼX����
	public int getLeftSeatBeginX() {
		return this.beginX + 12;
	}
	
	//�õ������λ�Ŀ�ʼY����
	public int getLeftSeatBeginY() {
		return this.beginY + 52;
	}
	
	public Rectangle getRange() {
		return range;
	}

	public void setRange(Rectangle range) {
		this.range = range;
	}

	public Seat getLeftSeat() {
		return leftSeat;
	}

	public Seat getRightSeat() {
		return rightSeat;
	}
	
	/**
	 * �õ����ӵ���߻����ұߵ�λ��
	 * @param side
	 * @return
	 */
	public Seat getSeat(String side) {
		if (Seat.LEFT.equals(side)) return this.leftSeat;
		else return this.rightSeat;
	}
		
	//�������ӱ��ȡ�����Ӷ���
	public static Table getTable(Integer tableNumber, Table[][] tables) {
		for (int i = 0; i < tables.length; i++) {
			for (int j = 0; j < tables[i].length; j++) {
				Table table = tables[i][j];
				if (tableNumber == table.getTableNumber()) return table;
			}
		}
		return null;
	}
	
	/**
	 * �õ���������ӵ�λ��
	 * @param user
	 * @return
	 */
	public Seat getUserSeat(ChessUser user) {
		if (this.leftSeat.getUser() != null) {
			if (this.leftSeat.getUser() != null) {
				if (user.getId().equals(this.leftSeat.getUser().getId())) {
					return this.leftSeat;
				}
			}
		}
		if (this.rightSeat.getUser() != null) {
			if (this.rightSeat.getUser() != null) {
				if (user.getId().equals(this.rightSeat.getUser().getId())) {
					return this.rightSeat;
				}
			}
		}
		return null;
	}
	
	/**
	 * �����������һ�ߵ���λ
	 * @param seat
	 * @return
	 */
	public Seat getAnotherSeat(Seat seat) {
		if (seat.getSide().equals(Seat.LEFT)) return this.rightSeat;
		else return this.leftSeat;
	}
	
	/**
	 * �õ�����
	 * @param user
	 * @return
	 */
	public ChessUser getAnotherUser(ChessUser user) {
		Seat seat = getUserSeat(user);
		if (seat == null) return null;
		Seat otherSeat = getAnotherSeat(seat);
		return otherSeat.getUser();
	}
}
