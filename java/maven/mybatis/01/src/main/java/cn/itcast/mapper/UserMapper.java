package cn.itcast.mapper;

import java.util.List;

import cn.itcast.User;

/**
 * 用户信息持久化接口
 * @author baifeng
 *
 */
public interface UserMapper {
	public User getUserById(Integer id);
	
	public List<User> getUserByName(String name);
	
	public void insertUser(User user);
}
