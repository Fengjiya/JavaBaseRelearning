package org.crazyit.book.service;

import java.util.Collection;

import org.crazyit.book.vo.Type;

public interface TypeService {

	/**
	 * �������е�����
	 * @return ��������ֵ���󼯺�
	 */
	Collection<Type> getAll();
	
	/**
	 * ������������ģ����������
	 * @param name ��������
	 * @return ���ҵĽ����
	 */
	Collection<Type> query(String name);
	
	/**
	 * ����һ���鱾����
	 * @param type ��Ҫ�����Ķ���
	 * @return ��������������
	 */
	Type add(Type type);
	
	/**
	 * �޸�һ���鱾����
	 * @param type ��Ҫ�޸ĵĶ���
	 * @return �޸ĺ�Ķ���
	 */
	Type update(Type type);
	
	/**
	 * ������������һ������
	 * @param id
	 * @return
	 */
	Type get(String id);
}
