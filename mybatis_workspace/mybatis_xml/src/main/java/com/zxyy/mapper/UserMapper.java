package com.zxyy.mapper;

import com.zxyy.domain.SysRole;
import com.zxyy.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<SysUser> findAll();
    SysUser findById(Long id);
    List<SysRole> selectRolesByUserId(Long id);
    List<SysRole> selectRolesAndUsernameByUserId(Long id);

    /**
     * 这个返回值是影响的行数，而不是主键id
     * @param user
     * @return
     */
    int save(SysUser user);

    /**
     * 这个返回值是获取主键的值，在insert标签上使用，通过xml文件中设置useGeneratedKeys属性为true，和KeyProperty属性为主键获取
     * @param user
     * @return
     */
    int save2(SysUser user);

    /**
     * 使用selectKey标签，并设置4个属性值
     * @param user
     * @return
     */
    int save3(SysUser user);

    /**
     * 使用update标签修改
     * @param user
     * @return
     */
    int updateById(SysUser user);

    /**
     * 通过主键删除，参数是long id  也可以是SysUser user ,不管是哪个参数，这里不需要修改mapper.xml中的配置
     * @param id
     * @return
     */
    int deleteById(Long id);

    SysUser selectByUserIdAndEnabled(@Param("userId") Long id,@Param("enabled") Integer enabled);
}
