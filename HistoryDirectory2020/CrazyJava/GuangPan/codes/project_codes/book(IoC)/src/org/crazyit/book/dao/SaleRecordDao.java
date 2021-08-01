package org.crazyit.book.dao;

import java.util.Collection;

import org.crazyit.book.vo.SaleRecord;

public interface SaleRecordDao {

	/**
	 * ������������, ������������֮��Ľ��׼�¼
	 * @param begin ��ʼ���ڵ��ַ���, ��ʽΪyyyy-MM-dd
	 * @param end �������ڵ��ַ���, ��ʽΪyyyy-MM-dd
	 * @return
	 */
	Collection<SaleRecord> findByDate(String begin, String end);
	
	/**
	 * ����id�������ۼ�¼
	 * @param id
	 * @return
	 */
	SaleRecord findById(String id);
	
	/**
	 * ����һ�����ۼ�¼
	 * @param record
	 * @return
	 */
	String save(SaleRecord record);
	
}
