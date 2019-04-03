package cn.itcast.store.dao;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Category;

public interface CategoryDao {

	List<Category> getAllCats() throws SQLException;

	void addCategory(Category category) throws SQLException;

}
