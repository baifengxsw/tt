package cn.itcast.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sys_role")
public class SysRole implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;
    @Column(name="role_name")
    private String roleName;
    @Column(name="role_memo")
    private String roleMemo;
    
    //多对多关系映射
    @ManyToMany
    @JoinTable(name="user_role_rel",//中间表的名称
              //中间表user_role_rel字段关联sys_role表的主键字段role_id
              joinColumns={@JoinColumn(name="role_id",referencedColumnName="role_id")},
              //中间表user_role_rel的字段关联sys_user表的主键user_id
              inverseJoinColumns={@JoinColumn(name="user_id",referencedColumnName="user_id")}
    )
    private Set<SysUser> users = new HashSet<SysUser>(0);
    
    
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleMemo() {
        return roleMemo;
    }
    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }
    public Set<SysUser> getUsers() {
        return users;
    }
    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }
    @Override
    public String toString() {
        return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", roleMemo=" + roleMemo + "]";
    }
}