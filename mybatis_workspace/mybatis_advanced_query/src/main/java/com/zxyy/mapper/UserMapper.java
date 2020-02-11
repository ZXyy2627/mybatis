package com.zxyy.mapper;

import com.zxyy.domain.SysRole;
import com.zxyy.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    SysUser selectUserAndRoleById(Long id);
    SysUser selectUserAndRoleById2(Long id);
    SysUser selectUserAndRoleByIdSelect(Long id);
    List<SysUser> selectAllUserAndRoles();

    List<SysUser> selectaaaaaaaa(Long userId);
}
