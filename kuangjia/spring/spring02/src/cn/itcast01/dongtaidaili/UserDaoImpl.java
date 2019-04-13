package cn.itcast01.dongtaidaili;

public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("保存");

	}

	@Override
	public void delete() {
		System.out.println("删除");
	}

	@Override
	public void update() {
		System.out.println("更新");
	}

	@Override
	public void find() {
		System.out.println("发现");
	}

}
