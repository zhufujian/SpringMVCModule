package org.SpringMVCModule_core.test;

import java.util.Date;

import org.SpringMVCModule_interface.domain.request.UserAddRequest;
import org.SpringMVCModule_interface.enums.StateEnum;
import org.SpringMVCModule_interface.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-dubbo-test.xml" })
public class UserServiceTest {
	
	@Autowired    
	private IUserService userService;
	
	
	@Test
	public void insert(){
		UserAddRequest request=new UserAddRequest();
		request.setId("sasaas");
		request.setLoginName("15990158365");
		request.setPassword("password"); 
		request.setRealName("小朱");
		request.setIsForbidden(StateEnum.ENABLE.getCode());
		request.setMobile("15990158365");
		request.setIcon("icon");
		request.setOrgId("orgId");
		request.setOrgName("orgName");
		request.setCreateDate(new Date());
		request.setUpdateDate(new Date());
		System.out.println("----------start---------");
		userService.insert(request);
		System.out.println("----------end---------");
	}
	
	

}
