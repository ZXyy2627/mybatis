package com.zxyy.mapper;

import com.zxyy.domain.SysRole;
import com.zxyy.domain.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest extends BaseMapperTest {

    private SqlSession sqlSession = getSqlSession();

    @Test
    public void testFindAll() {
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> list = userMapper.findAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size()>0);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testFindById() {
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.findById(1L);
            Assert.assertNotNull(sysUser);
            Assert.assertEquals("admin",sysUser.getUserName());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysRole> roles = userMapper.selectRolesByUserId(1L);
        Assert.assertNotNull(roles);
        Assert.assertTrue(roles.size()>0);
    }

    @Test
    public void testSelectRolesAndUsernameByUserId(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysRole> sysRoles = userMapper.selectRolesAndUsernameByUserId(1L);
        Assert.assertNotNull(sysRoles);
        Assert.assertTrue(sysRoles.size()>0);
    }

    @Test
    public void testSave(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(3L);
            user.setUserName("zxyy");
            user.setUserPassword("aaa");
            user.setUserEmail("aa@itcast.com");
            user.setUserInfo("好");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            userMapper.save(user);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSave2(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser user = new SysUser();
        user.setId(3L);
        user.setUserName("zxyy");
        user.setUserPassword("aaa");
        user.setUserEmail("aa@itcast.com");
        user.setUserInfo("好");
        user.setHeadImg(new byte[]{1,2,3});
        user.setCreateTime(new Date());
        int i = userMapper.save2(user);
        Assert.assertTrue(i != 0);
    }

    @Test
    public void testSave3(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser user = new SysUser();
        user.setId(3L);
        user.setUserName("zxyy");
        user.setUserPassword("aaa");
        user.setUserEmail("aa@itcast.com");
        user.setUserInfo("好");
        user.setHeadImg(new byte[]{1,2,3});
        user.setCreateTime(new Date());
        long id = userMapper.save3(user);
        System.out.println(id);
    }

    @Test
    public void testUpdateById(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setId(1L);
            sysUser.setUserName("admin_test");
            sysUser.setUserEmail("test@itcast.com");
            userMapper.updateById(sysUser);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int num = userMapper.deleteById(1001L);
            System.out.println(num);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUserIdAndEnabled(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectByUserIdAndEnabled(1L, 1);
            System.out.println(sysUser);
        }finally {
            sqlSession.close();
        }
    }
}