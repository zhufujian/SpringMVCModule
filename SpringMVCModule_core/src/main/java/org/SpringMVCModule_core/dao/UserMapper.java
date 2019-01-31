package org.SpringMVCModule_core.dao;

import java.util.List;

import org.SpringMVCModule_core.domain.User;
import org.SpringMVCModule_core.domain.UserExample;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}