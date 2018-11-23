package cn.itcast05_commoncrud;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {
	
	T  handle(ResultSet rs);
	
}
