package com.zxyy.mapper;

import com.zxyy.domain.SysRole;
import com.zxyy.type.Enabled;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class RoleMapperTest extends BaseMapperTest{
    private SqlSession sqlSession = getSqlSession();

    @Test
    public void testSelectById(){
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        SysRole sysRole = roleMapper.selectById(1L);
        System.out.println(sysRole);
        sqlSession.close();
    }

    @Test
    public void testSelectById2(){
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        SysRole sysRole = mapper.selectById2(1L);
        System.out.println(sysRole);
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<SysRole> sysRoles = mapper.selectAll();
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }

    @Test
    public void testSave1(){
        try{
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("zxyy");
            sysRole.setEnabled(Enabled.enabled);
            sysRole.setCreateBy("1");
            sysRole.setCreateTime(new Date());
            int count = mapper.save1(sysRole);
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }

    }
}