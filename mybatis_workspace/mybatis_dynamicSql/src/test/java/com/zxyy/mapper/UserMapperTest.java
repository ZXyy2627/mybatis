package com.zxyy.mapper;

import com.zxyy.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UserMapperTest extends BaseMapperTest{

    private SqlSession sqlSession = getSqlSession();

    @Test
    public void testSelectByUser(){
        SysUser sysUser = new SysUser();
        sysUser.setUserName("ad");
        sysUser.setUserEmail("admin@mybatis.tk");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> sysUsers = mapper.selectByUser(sysUser);
        for (SysUser user : sysUsers) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateByIdSelective(){
        try{
            SysUser sysUser = new SysUser();
            sysUser.setId(1001L);
            sysUser.setUserName("test1001");
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateByIdSelective(sysUser);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }

    @Test
    public void testSave666(){
        try{
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test2");
            sysUser.setUserPassword("123");
            sysUser.setUserEmail("test666@mybatis.tk");
            sysUser.setHeadImg(new byte[]{1,2,3});
            sysUser.setUserInfo("测试用户");
            sysUser.setCreateTime(new Date());
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.save666(sysUser);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }

    @Test
    public void testSelectByIdOrUsername(){
        SysUser sysUser = new SysUser();
//        sysUser.setId(1L);
//        sysUser.setUserName("admin");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser1 = mapper.selectByIdOrUsername(sysUser);
        System.out.println(sysUser1);
    }


    @Test
    public void testSelectByUser2(){
        SysUser sysUser = new SysUser();
//        sysUser.setUserEmail("test@mybatis.tk");
//        sysUser.setId(1001L);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> sysUsers = mapper.selectByUser2(sysUser);
        for (SysUser user : sysUsers) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateByIdSelective2(){
        try{
            SysUser sysUser = new SysUser();
            sysUser.setId(1L);
            sysUser.setUserName("adminminmin");
            sysUser.setUserEmail("adminminmin@mybatis.tk");
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateByIdSelective2(sysUser);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdList(){
        /*
           如果参数是list集合，则collection属性填list
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(1001L);*/

        /*
        * 如果参数是数组呢
        *
        * */
        //long[] arr = {1L,1001L};
        /*
        * 如果是map集合呢？
        * */
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userName","admin");
        List<Long> ids = new ArrayList<Long>();
        ids.add(1L);
        ids.add(1001L);
        map.put("ids",ids);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> sysUsers = mapper.selectByIdList(map);
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }
    }


    @Test
    public void testInsertMany(){
        try{
            List<SysUser> list = new ArrayList<SysUser>();
            SysUser sysUser1 = new SysUser();
            sysUser1.setId(1002L);
            sysUser1.setUserName("admin1002");
            sysUser1.setUserPassword("123");
            sysUser1.setUserEmail("aa@mybatis.tk");
            sysUser1.setUserInfo("测试用户");
            sysUser1.setHeadImg(new byte[]{1,2,3});
            sysUser1.setCreateTime(new Date());
            list.add(sysUser1);
            SysUser sysUser2 = new SysUser();
            sysUser1.setId(1003L);
            sysUser1.setUserName("admin1003");
            sysUser1.setUserPassword("123");
            sysUser1.setUserEmail("bb@mybatis.tk");
            sysUser1.setUserInfo("测试用户");
            sysUser1.setHeadImg(new byte[]{2,3,4});
            sysUser1.setCreateTime(new Date());
            list.add(sysUser2);

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.insertMany(list);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByForeach(){
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("id",1L);
            map.put("user_name","admin2222");
            map.put("user_email","admin2222@mybatis.tk");
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateByForeach(map);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}