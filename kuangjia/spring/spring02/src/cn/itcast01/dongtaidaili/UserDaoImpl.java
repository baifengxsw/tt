package cn.itcast01.dongtaidaili;

public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("����");

	}

	@Override
	public void delete() {
		System.out.println("ɾ��");
	}

	@Override
	public void update() {
		System.out.println("����");
	}

	@Override
	public void find() {
		System.out.println("����");
	}

}
