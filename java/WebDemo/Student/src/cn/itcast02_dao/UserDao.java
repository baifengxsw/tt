package cn.itcast02_dao;
/**
 * 创建数据库登录相关的操作接口
 * @author baifeng
 *
 */
public interface UserDao {
  /**
   * 这里简单返回boolean类型 ,成功或者失败 即可,正常登录成功就返回用户所有信息 
   *@return true 登录成功  false 登录失败
   */
	boolean login(String username, String password);
	
}
