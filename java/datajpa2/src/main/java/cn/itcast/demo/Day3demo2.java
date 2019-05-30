package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.dao.SysRoleDao;
import cn.itcast.dao.SysUserDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.entity.SysRole;
import cn.itcast.entity.SysUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class Day3demo2 {
    @Autowired
    private SysRoleDao roleDao;
    
    @Autowired
    private SysUserDao userDao;
    
    
    /**
     * 保存操作
     * 需求:
     *  保存一个客户和一个联系人
     * 要求：
     *  创建一个客户对象和一个联系人对象
     *  建立客户和联系人之间关联关系（双向一对多的关联关系）
     *  先保存客户，再保存联系人
     * 问题：
     *      当我们建立了双向的关联关系之后，先保存主表，再保存从表时：
     *      会产生2条insert和1条update.
     *      而实际开发中我们只需要2条insert。
     * 
     */
    @Test
    @Transactional  //开启事务
    @Rollback(false)//设置为不回滚
    public void test1(){
        //创建对象
        SysUser u1 = new SysUser();
        u1.setUserName("用户1");
        SysRole r1 = new SysRole();
        r1.setRoleName("角色1");
        //建立关联关系
        u1.getRoles().add(r1);
        r1.getUsers().add(u1);
        //保存
        roleDao.save(r1);
        userDao.save(u1);
    }

}