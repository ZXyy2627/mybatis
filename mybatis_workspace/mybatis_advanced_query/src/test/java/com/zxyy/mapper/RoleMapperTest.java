package com.zxyy.mapper;

import com.zxyy.domain.SysPrivilege;
import com.zxyy.domain.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RoleMapperTest extends BaseMapperTest{
        private SqlSession sqlSession = getSqlSession();

        @Test
        public void testSelectRoleAndPrivileges(){
            try{
                RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
                List<SysRole> sysRoles = mapper.selectRoleAndPrivileges();
                for (SysRole sysRole : sysRoles) {
                    System.out.println("角色名："+sysRole.getRoleName());
                    for (SysPrivilege sysPrivilege : sysRole.getPrivilegeList()) {
                        System.out.println("权限名："+sysPrivilege.getPrivilegeName());
                    }
                }
            }finally {
                sqlSession.close();
            }
        }

        @Test
        public void testSelectRoleByUserIdChoose(){
            try{
                RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
                List<SysRole> sysRoles = mapper.selectRoleByUserIdChoose(1L);
                for (SysRole sysRole : sysRoles) {
                    System.out.println(sysRole);
                }
            }finally {
                sqlSession.close();
            }
        }
}