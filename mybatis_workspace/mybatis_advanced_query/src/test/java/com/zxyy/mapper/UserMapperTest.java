package com.zxyy.mapper;

import com.zxyy.domain.SysPrivilege;
import com.zxyy.domain.SysRole;
import com.zxyy.domain.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest extends BaseMapperTest{
    private SqlSession sqlSession = getSqlSession();

    @Test
    public void testSelectUserAndRoleById(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = mapper.selectUserAndRoleById(1001L);
        System.out.println(sysUser.toString());
    }

    @Test
    public void testSelectUserAndRoleById2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = mapper.selectUserAndRoleById2(1001L);
        System.out.println(sysUser);
    }

    @Test
    public void testSelectUserAndRoleByIdSelect(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = mapper.selectUserAndRoleByIdSelect(1001L);
//        System.out.println(sysUser.getRole());
        Assert.assertNotNull(sysUser);
    }

    @Test
    public void testSelectAllUserAndRoles(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> list = mapper.selectaaaaaaaa(1L);
        System.out.println("用户数:"+list.size());
        for (SysUser sysUser : list) {
            System.out.println("用户名:"+ sysUser.getUserName());
            for (SysRole sysRole : sysUser.getRoleList()) {
                System.out.println("角色名："+sysRole.getRoleName());
                for (SysPrivilege sysPrivilege : sysRole.getPrivilegeList()) {
                    System.out.println("权限名:"+sysPrivilege.getPrivilegeName());
                }
            }
        }
    }
}