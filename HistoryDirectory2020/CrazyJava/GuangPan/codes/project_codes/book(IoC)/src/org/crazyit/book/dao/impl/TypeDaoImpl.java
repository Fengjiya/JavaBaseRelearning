package org.crazyit.book.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.crazyit.book.dao.TypeDao;
import org.crazyit.book.vo.Type;

public class TypeDaoImpl extends CommonDaoImpl implements TypeDao {

	public Collection<Type> find() {
		String sql = "select * from T_BOOK_TYPE type ORDER BY type.ID DESC";
		return getDatas(sql, new Vector(), Type.class);
	}
	
	public String add(Type type) {
		String sql = "INSERT INTO T_BOOK_TYPE VALUES (ID, '" + 
		type.getTYPE_NAME() + "', '" + type.getTYPE_INTRO() + "')";
		String id = String.valueOf(getJDBCExecutor().executeUpdate(sql));
		return id;
	}

	@Override
	public Type find(String id) {
		String sql = "SELECT * FROM T_BOOK_TYPE type WHERE type.ID=" + id;
		List<Type> datas =  (List<Type>)getDatas(sql, new ArrayList(), Type.class);
		return datas.get(0);
	}

	@Override
	public Collection<Type> findByName(String name) {
		String sql = "SELECT * FROM T_BOOK_TYPE type WHERE type.TYPE_NAME like '%" + name + "%' " +
				"ORDER BY type.ID DESC";
		List<Type> datas =  (List<Type>)getDatas(sql.toString(), new Vector(), Type.class);
		return datas;
	}

	@Override
	public String update(Type type) {
		String sql = "UPDATE T_BOOK_TYPE type SET type.TYPE_NAME='" + type.getTYPE_NAME() + 
		"', type.TYPE_INTRO='" + type.getTYPE_INTRO() + "' WHERE type.ID='" + type.getID() + "'";
		getJDBCExecutor().executeUpdate(sql);
		return type.getID();
	}

}
