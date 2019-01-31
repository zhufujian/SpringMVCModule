package org.SpringMVCModule_core.RPCservice;

import java.util.List;

import org.SpringMVCModule_core.common.annotation.Dubbo;
import org.SpringMVCModule_core.common.enums.InterfaceTypeEnum;
import org.SpringMVCModule_core.common.exceptions.BizException;
import org.SpringMVCModule_core.common.utils.AssertUtil;
import org.SpringMVCModule_core.common.utils.ContextHolder;
import org.SpringMVCModule_core.dao.UserMapper;
import org.SpringMVCModule_core.domain.User;
import org.SpringMVCModule_interface.domain.request.UserAddRequest;
import org.SpringMVCModule_interface.domain.request.UserSingleQueryRequest;
import org.SpringMVCModule_interface.domain.response.UserSingleQueryResponse;
import org.SpringMVCModule_interface.enums.ResultCodeEnum;
import org.SpringMVCModule_interface.service.IUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class UserService extends BaseService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public List<UserSingleQueryResponse> selectByExampleWithRowbounds(
			UserSingleQueryRequest request, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		logger.info("selectByExampleWithRowbounds");
		return null;
	}

	@Override
	public List<UserSingleQueryResponse> selectByExample(UserSingleQueryRequest request) {
		logger.info("selectByExample");
		return null;
	}

	@Override
	public UserSingleQueryResponse selectByPrimaryKey(String id) {
		logger.info("selectByPrimaryKey");
		return null;
	}

	@Override
	@Dubbo(operCode = InterfaceTypeEnum.ADD_USER, clazz = UserSingleQueryResponse.class)
	public UserSingleQueryResponse insert(UserAddRequest request) {
		User user=new User();
	    BeanUtils.copyProperties(request, user);
		AssertUtil.bigger(userMapper.insert(user), 1, new BizException(ResultCodeEnum.SYSTEM_ERROR));
		;
		UserSingleQueryResponse baseResponse= new UserSingleQueryResponse();
	    baseResponse.setCorrelationID(ContextHolder.getCorrelationID());
	    baseResponse.setRetcode(ResultCodeEnum.SUCCESS.getCode());
	    baseResponse.setRetmsg(ResultCodeEnum.SUCCESS.getDesc());
		return baseResponse;
	}

}
