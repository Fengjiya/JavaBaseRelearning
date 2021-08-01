package org.crazyit.book.vo;

import java.util.Vector;

/**
 * ���ۼ�¼
 * @author yangenxiong
 *
 */
public class SaleRecord extends ValueObject {
	//��������
	private String RECORD_DATE;
	//���۵�������
	private int amount;
	//�ܼ�Ǯ
	private double totalPrice;
	//������ۼ�¼
	private Vector<BookSaleRecord> bookSaleRecords;
	
	//�ü�¼�ж�Ӧ�����������, ��ʾ��
	private String bookNames;

	public String getRECORD_DATE() {
		return RECORD_DATE;
	}

	public void setRECORD_DATE(String record_date) {
		RECORD_DATE = record_date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Vector<BookSaleRecord> getBookSaleRecords() {
		return bookSaleRecords;
	}

	public void setBookSaleRecords(Vector<BookSaleRecord> bookSaleRecords) {
		this.bookSaleRecords = bookSaleRecords;
	}

	public String getBookNames() {
		return bookNames;
	}

	public void setBookNames(String bookNames) {
		this.bookNames = bookNames;
	}
	
	
}
