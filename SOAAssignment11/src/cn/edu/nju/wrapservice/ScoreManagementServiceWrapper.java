package cn.edu.nju.wrapservice;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import cn.edu.nju.common.ServiceTypes;
import cn.edu.nju.common.States;
import cn.edu.nju.handlers.ClientHandlerResolver;
import cn.edu.nju.score_manage.InvalidCourseId;
import cn.edu.nju.score_manage.InvalidScore;
import cn.edu.nju.score_manage.InvalidStudentId;
import cn.edu.nju.score_manage.ScoreManageService;
import cn.edu.nju.score_manage.ScoreManageServiceImplService;
import cn.edu.nju.score_manage.学号课程号类型;
import cn.edu.nju.score_manage.排序类型;
import cn.edu.nju.score_manage.课程成绩列表类型;
import cn.edu.nju.score_manage.课程成绩类型;

public class ScoreManagementServiceWrapper implements ScoreManageService {

    private static final QName SERVICE_NAME = new QName("http://jw.nju.edu.cn/wsdl", "ScoreManageServiceImplService");

    private ScoreManageService serviceImpl = null;
    
	private ScoreManagementServiceWrapper() {
		URL wsdlURL = ScoreManageServiceImplService.WSDL_LOCATION;
		ScoreManageServiceImplService ss = new ScoreManageServiceImplService(wsdlURL, SERVICE_NAME);
		ss.setHandlerResolver(new ClientHandlerResolver());
        serviceImpl = ss.getScoreManageServicePort();  
	}
	
	@Override
	public 课程成绩列表类型 deleteGrade(学号课程号类型 parameters) throws InvalidCourseId, InvalidStudentId {
		States.setServiceType(ServiceTypes.DEL_GRADE);
		return serviceImpl.deleteGrade(parameters);
	}

	@Override
	public 课程成绩列表类型 queryGrade(String parameters) throws InvalidStudentId {
		States.setServiceType(ServiceTypes.QUERY_GRADE);
		return serviceImpl.queryGrade(parameters);
	}

	@Override
	public 课程成绩列表类型 modifyGrade(课程成绩类型 parameters) throws InvalidCourseId, InvalidStudentId, InvalidScore {
		States.setServiceType(ServiceTypes.MOD_GRADE);
		return serviceImpl.modifyGrade(parameters);
	}

	@Override
	public 课程成绩列表类型 sortGrade(排序类型 parameters) throws InvalidCourseId, InvalidStudentId {
		return null;
	}

	@Override
	public void addGrade(Holder<课程成绩列表类型> parameters) throws InvalidCourseId, InvalidStudentId, InvalidScore {
		States.setServiceType(ServiceTypes.ADD_GRADE);
		serviceImpl.addGrade(parameters);
	}
	
	public static ScoreManageService getInstance() {
		return new ScoreManagementServiceWrapper();
	}

}
