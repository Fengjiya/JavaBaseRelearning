package org.crazyit.book.service.impl;

import java.util.Collection;

import org.crazyit.book.dao.TypeDao;
import org.crazyit.book.service.TypeService;
import org.crazyit.book.vo.Type;

public class TypeServiceImpl implements TypeService {

	private TypeDao dao;
	
	//��ֵע����Ҫ�ṩ��setter����
	public void setTypeDao(TypeDao dao) {
		this.dao = dao;
	}
	
	public Collection<Type> query(String name) {
		return dao.findByName(name);
	}

	public Collection<Type> getAll() {
		return dao.find();
	}

	public Type add(Type type) {
		String id = dao.add(type);
		return get(id);
	}

	public Type update(Type type) {
		// TODO Auto-generated method stub
		String id = dao.update(type);
		return get(id);
	}
	
	public Type get(String id) {
		return dao.find(id);
	}

}
