package cn.itcast.store.service.serviceImpl;

import java.sql.SQLException;

import cn.itcast.store.dao.UserDao;
import cn.itcast.store.dao.DaoImpl.UserDaoImpl;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;
import cn.itcast.store.utils.BeanFactory;

public class UserServiceImpl implements UserService {

	UserDao ud = (UserDao) BeanFactory.createObject("UserDao");
	public void userRegist(User user) throws SQLException {
		ud.userRegist(user);
		
	}

	public boolean userActive(String code) throws SQLException {
		
		User user = ud.userActive(code);
		
		if(user!=null) {
			//�鵽��ص��û�
			//�޸�״̬ ���������
			user.setState(1);
			user.setCode(null);
			ud.updateUser(user);
			return true;
		}else {
			
			return false;
		}
	}

	public User userLogin(User user) throws SQLException {
		
		User ret = ud.userLogin(user);
		if(ret == null) {
			throw new RuntimeException("�������");
		}else if(ret.getState()==0) {
			throw new RuntimeException("�û�δ����");
		
		}else {
			return ret;
		}
	}

}
