package com.zxyy.mapper;

import com.zxyy.domain.SysPrivilege;
import com.zxyy.domain.SysRole;

import java.util.List;

public interface RoleMapper {
    SysRole selectRoleById(Long id);
    List<SysRole> selectRoleAndPrivileges();

    List<SysRole> selectRoleByUserIdChoose(Long userId);
}
