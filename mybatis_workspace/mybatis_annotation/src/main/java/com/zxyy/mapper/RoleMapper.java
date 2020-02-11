package com.zxyy.mapper;

import com.zxyy.domain.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    /**
     * 根据Id查询角色
     * @param id
     * @return
     */
    @Select({"select id,role_name roleName,enabled,create_by createBy,create_time createTime from sys_role where id=#{id}"})
    SysRole selectById(Long id);

    /**
     * 使用@Results注解
     * @param id
     * @return
     */
    @Results(id="roleResultMap",value = {
                @Result(property = "id",column = "id", id = true),
                @Result(property = "roleName",column = "role_name"),
                @Result(property = "enabled",column = "enabled"),
                @Result(property="createBy",column = "create_by"),
                @Result(property = "createTime",column = "create_time")}
            )
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role where id=#{id} "})
    SysRole selectById2(Long id);


//    @ResultMap("roleResultMap")//不仅可以引用接口中使用注解定义的返回类型，也可以配合XML使用
    @ResultMap("roleResultMap2")
    @Select({"select * from sys_role"})
    List<SysRole> selectAll();

    /**
     * 不需要返回主键的保存方法
     * @param sysRole
     * @return
     */
    @Insert({"insert into sys_role (id,role_name,enabled,create_by,create_time) values (#{id},#{roleName},#{enabled}," +
            "#{createBy},#{createTime})"})
    int save1(SysRole sysRole);


}
