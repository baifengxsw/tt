package cn.itcast.store.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.domain.Category;

public interface CategoryService {

	List<Category> getAllCats() throws SQLException;

	void addCategory(Category category)throws SQLException;



}
