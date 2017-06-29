package cn.edu.nju.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.edu.nju.student_info.StudentInfoService;
import cn.edu.nju.wrapservice.StudentInfoServiceWrapper;

public class SOAClientTest {

	@Test
	public void test() {
		// Example
		StudentInfoService service = StudentInfoServiceWrapper.getInstance(); 
		//service.queryInfo("141250161");
		fail("Not yet implemented");
	}

}
