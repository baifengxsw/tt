package cn.itcast.erp.action;
import cn.itcast.erp.biz.IRoleBiz;
import cn.itcast.erp.entity.Role;

/**
 * 角色Action 
 * @author Administrator
 *
 */
public class RoleAction extends BaseAction<Role> {

	private IRoleBiz roleBiz;

	public void setRoleBiz(IRoleBiz roleBiz) {
		this.roleBiz = roleBiz;
		super.setBaseBiz(this.roleBiz);
	}

}
