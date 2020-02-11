package com.zxyy.mapper;

import com.zxyy.domain.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

public interface PrivilegeMapper {
    //type属性指定XXXProvider类，method属性指定方法 类似于select标签中的id一样
    @SelectProvider(type = PrivilegeProvider.class,method = "selectById")
    SysPrivilege selectById(Long id);
}
