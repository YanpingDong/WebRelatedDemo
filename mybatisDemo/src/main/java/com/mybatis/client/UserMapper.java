package com.mybatis.client;

import com.mybatis.entity.User;
import com.mybatis.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	/*
	 * 所有方法在mapper中都有一个同名的sql对应(注解的除外)
	 */
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select("select * from test_user where id = #{id}")
    User selectByPrimaryKey(String id);

    /*
     * @Param的作用:使mybatis支持多类型参数   以前的mybatis不支持多类型参数,如果你的参数来自不同类型的对象,那么必须自己构建map传参
     * 而现在,只需要使用@Param,就可以传入多个类型的参数, 
     * 如下面的方法:updateByExampleSelective对应的sql中,我们就可以同时使用#{record.id}和#{example.name}作为参数
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}