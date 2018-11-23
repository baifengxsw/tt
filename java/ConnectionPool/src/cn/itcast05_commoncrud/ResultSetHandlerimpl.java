package cn.itcast05_commoncrud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetHandlerimpl  implements ResultSetHandler<Account>{
	List<Account> list = new ArrayList<>();
	@Override
	public Account handle(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			Account account = new Account();
			if (rs.next()){
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setMoney(rs.getInt("money"));
				
			}
			return account;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
