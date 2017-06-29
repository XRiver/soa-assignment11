package cn.edu.nju.test;

import org.junit.Before;
import org.junit.Test;

import cn.edu.nju.login.EmailPwdException;
import cn.edu.nju.login.ParamNullException;
import cn.edu.nju.login.UserEntity;
import cn.edu.nju.login.UserService;
import cn.edu.nju.score_manage.ScoreManageService;
import cn.edu.nju.student_info.InvalidStudentId;
import cn.edu.nju.student_info.StudentInfoService;
import cn.edu.nju.wrapservice.ScoreManagementServiceWrapper;
import cn.edu.nju.wrapservice.StudentInfoServiceWrapper;
import cn.edu.nju.wrapservice.UserServiceWrapper;

public class SOAClientTest {
	UserService service1;
	StudentInfoService service2;
	ScoreManageService service3;

	@Before
	public void init() {
		service1 = UserServiceWrapper.getInstance();
		service2 = StudentInfoServiceWrapper.getInstance();
		service3 = ScoreManagementServiceWrapper.getInstance();
	}

	// 情景一 ：学生登录成功，查看学生信息和成绩信息都成功，但是想要修改时出错，提示权限不够的情况
	@Test
	public void test1() {
		try {
			UserEntity user = service1.login("student@smail.nju.edu.cn", "123");
			System.out.println(user);

		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailPwdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 情景二 ：老师登录成功，对学生信息和成绩信息进行操作
	@Test
	public void test2() {
		try {
			UserEntity user = service1.login("teacher@smail.nju.edu.cn", "123");
			System.out.println(user);

		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailPwdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 情景三 ：无权限者登录成功，不论是查看还是修改均失败，提示权限不够
	@Test
	public void test3() {
		try {
			UserEntity user = service1.login("none@smail.nju.edu.cn", "123");
			System.out.println(user);
		} catch (ParamNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailPwdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			service2.queryInfo("141250179");
		} catch (InvalidStudentId e) {
			// TODO Auto-generated catch block
			System.err.println(e.getFaultInfo());
		}
	}

	// 情景四 ：登录错误
	@Test
	public void test4() {
		try {
			UserEntity user1 = service1.login("teacher@smail.nju.edu.cn", "12");
		} catch (ParamNullException e) {
			System.err.println("参数为空：" + e.getMessage());
		} catch (EmailPwdException e) {
			System.err.println("密码或邮箱有误：" + e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			UserEntity user2 = service1.login("teacher@smail.nju.edu.cn", "");
		} catch (ParamNullException e) {
			System.err.println("参数为空：" + e.getMessage());
		} catch (EmailPwdException e) {
			System.err.println("密码或邮箱有误：" + e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
