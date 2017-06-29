package cn.edu.nju.wrapservice;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import cn.edu.nju.common.ServiceTypes;
import cn.edu.nju.common.States;
import cn.edu.nju.handlers.ClientHandlerResolver;
import cn.edu.nju.student_info.DataFormatError;
import cn.edu.nju.student_info.InvalidStudentId;
import cn.edu.nju.student_info.StudentInfoService;
import cn.edu.nju.student_info.StudentInfoServiceImplService;
import cn.edu.nju.student_info.学号类型;
import cn.edu.nju.student_info.学生信息;

public class StudentInfoServiceWrapper implements StudentInfoService {

	private static final QName SERVICE_NAME = new QName("http://jw.nju.edu.cn/wsdl", "StudentInfoServiceImplService");

	private StudentInfoService serviceImpl;
	
	private StudentInfoServiceWrapper() {
		URL wsdlURL = StudentInfoServiceImplService.WSDL_LOCATION;
		StudentInfoServiceImplService ss = new StudentInfoServiceImplService(wsdlURL, SERVICE_NAME);
        ss.setHandlerResolver(new ClientHandlerResolver());
        serviceImpl = ss.getStudentInfoServicePort();  
	}
	
	@Override
	public void addInfo(Holder<学生信息> parameters) throws DataFormatError {
		States.setServiceType(ServiceTypes.ADD_INFO);
		serviceImpl.addInfo(parameters);
	}

	@Override
	public 学生信息 deleteInfo(学号类型 parameters) throws InvalidStudentId {
		States.setServiceType(ServiceTypes.DEL_INFO);
		return serviceImpl.deleteInfo(parameters);
	}

	@Override
	public void modifyInfo(Holder<学生信息> parameters) throws DataFormatError {
		States.setServiceType(ServiceTypes.MODIFY_INFO);
		modifyInfo(parameters);
	}

	@Override
	public 学生信息 queryInfo(String parameters) throws InvalidStudentId {
		States.setServiceType(ServiceTypes.QUERY_INFO);
		return serviceImpl.queryInfo(parameters);
	}

	public static StudentInfoService getInstance() {
		return new StudentInfoServiceWrapper();
	}
}
