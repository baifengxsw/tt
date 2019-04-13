package cn.itcast.dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//HQL面向对象
		Query query = session.createQuery("from User where user_name=? and user_password=?");
		query.setParameter(0, user.getUser_name());
		query.setParameter(1, user.getUser_password());
		User retUser = (User)query.uniqueResult();
		tx.commit();
		return retUser;
	}

}
