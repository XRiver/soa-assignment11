package cn.edu.nju.test;

import org.junit.Before;
import org.junit.Test;

import cn.edu.nju.login.UserService;
import cn.edu.nju.student_info.StudentInfoService;
import cn.edu.nju.wrapservice.StudentInfoServiceWrapper;

public class SOAClientTest {
	@Before
	public void init(){
//		UserService service = l
		StudentInfoService service = StudentInfoServiceWrapper.getInstance(); 
		
	}
	@Test
	public void test() {
		// Example
		
		//service.queryInfo("141250161");
	}
	

}
