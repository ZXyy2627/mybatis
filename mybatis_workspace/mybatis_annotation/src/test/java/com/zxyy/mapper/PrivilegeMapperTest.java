package com.zxyy.mapper;

import com.zxyy.domain.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrivilegeMapperTest extends BaseMapperTest{

    private SqlSession sqlSession = getSqlSession();

    @Test
    public void testSelectById(){
        PrivilegeMapper mapper = sqlSession.getMapper(PrivilegeMapper.class);
        SysPrivilege sysPrivilege = mapper.selectById(1L);
        System.out.println(sysPrivilege);
    }

}