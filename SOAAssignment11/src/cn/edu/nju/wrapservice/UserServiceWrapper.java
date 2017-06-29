package cn.edu.nju.wrapservice;

import java.net.URL;

import javax.xml.namespace.QName;

import cn.edu.nju.common.ServiceTypes;
import cn.edu.nju.common.States;
import cn.edu.nju.common.UserIdentity;
import cn.edu.nju.handlers.ClientHandlerResolver;
import cn.edu.nju.login.EmailPwdException;
import cn.edu.nju.login.ParamNullException;
import cn.edu.nju.login.UserEntity;
import cn.edu.nju.login.UserService;
import cn.edu.nju.login.UserService_Service;

public class UserServiceWrapper implements UserService {

	private static final QName SERVICE_NAME = new QName("http://service.student.nju.edu/", "UserService");
	
	private UserService serviceImpl = null;
	
	private UserServiceWrapper() {
		URL wsdlURL = UserService_Service.WSDL_LOCATION;
		
		UserService_Service ss = new UserService_Service(wsdlURL, SERVICE_NAME);
		ss.setHandlerResolver(new ClientHandlerResolver());
        serviceImpl = ss.getUserServiceImplPort();  
	}
	
	
	@Override
	public UserEntity login(String email, String password) throws ParamNullException, EmailPwdException {
		States.setServiceType(ServiceTypes.LOG_IN);
		
		try {
			UserEntity u = serviceImpl.login(email, password);
			States.setIdentity(UserIdentity.fromId(u.getId()));
			return u;
		} catch (Exception e) {
			String errMsg = e.getMessage();
			if (errMsg.contains("email or password wrong")) {
				throw new EmailPwdException();
			} else if(errMsg.contains("login")){
				throw new ParamNullException();
			} else {
				throw e;
			}
		}
	}

	public static UserService getInstance() {
		return new UserServiceWrapper();
	}
}
