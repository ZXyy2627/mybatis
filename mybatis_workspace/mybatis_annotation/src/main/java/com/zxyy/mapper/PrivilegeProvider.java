package com.zxyy.mapper;

import org.apache.ibatis.jdbc.SQL;

public class PrivilegeProvider {
    //1.必须要有空参构造器

    public PrivilegeProvider() {
    }
    //2.提供和接口中方法同名的方法，返回值是String类型
    public String selectById(final Long id){
        /*return new SQL(){
            {
                //这是一种写法，类似字符串的拼接
                SELECT("id,privilege_name,privilege_url");
                FROM("sys_privilege");
                WHERE("id=#{id}");
            }
        }.toString();*/
        //或者直接返回一个string字符串
        return "select id,privilege_name,privilege_url from sys_privilege where id=#{id}";
    }
}
