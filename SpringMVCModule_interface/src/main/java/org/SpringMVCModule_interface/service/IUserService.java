package org.SpringMVCModule_interface.service;

import java.util.List;

import org.SpringMVCModule_interface.domain.request.UserAddRequest;
import org.SpringMVCModule_interface.domain.request.UserSingleQueryRequest;
import org.SpringMVCModule_interface.domain.response.UserSingleQueryResponse;
import org.apache.ibatis.session.RowBounds;

public interface IUserService {


    List<UserSingleQueryResponse> selectByExampleWithRowbounds(UserSingleQueryRequest request, RowBounds rowBounds);

    List<UserSingleQueryResponse> selectByExample(UserSingleQueryRequest request);

    UserSingleQueryResponse selectByPrimaryKey(String id);
    
    UserSingleQueryResponse insert(UserAddRequest userAddRequest);
}
