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
import cn.edu.nju.student_info.个人信息类型;
import cn.edu.nju.student_info.地址类型;
import cn.edu.nju.student_info.学生信息;
import cn.edu.nju.student_info.课程成绩列表类型;
import cn.edu.nju.student_info.部门类型;
import cn.edu.nju.wrapservice.ScoreManagementServiceWrapper;
import cn.edu.nju.wrapservice.StudentInfoServiceWrapper;
import cn.edu.nju.wrapservice.UserServiceWrapper;

public class SOAClientTest {
	UserService service1;
	StudentInfoService service2;
	ScoreManageService service3;
	学生信息 student1;
	学生信息 student2;

	@Before
	public void init() {
		service1 = UserServiceWrapper.getInstance();
		service2 = StudentInfoServiceWrapper.getInstance();
		service3 = ScoreManagementServiceWrapper.getInstance();
		student1 = new 学生信息();
		student1.set学号("141250124");
		个人信息类型 personalInfo1 = new 个人信息类型();
		personalInfo1.set地址(new 地址类型("江苏省","南京市","鼓楼区","汉口路","22号"));
		personalInfo1.set姓名("汤大业");
		personalInfo1.set婚姻状况("未婚");
		personalInfo1.set座机号码("1234-5678");
		personalInfo1.set性别("男");
		personalInfo1.set手机号码("183xxxx6292");
		personalInfo1.set教育背景("本科");
		personalInfo1.set部门(new 部门类型());
		student1.set基本信息(personalInfo1);
		student1.set年级("大三");
		student1.set课程成绩列表(new 课程成绩列表类型());
		
		student2 = new 学生信息();
		student2.set学号("141250124");
		个人信息类型 personalInfo2 = new 个人信息类型();
		personalInfo2.set地址(new 地址类型("江苏省","徐州市","云龙区","铜山路","209号"));
		personalInfo1.set姓名("zyq");
		personalInfo1.set婚姻状况("未婚");
		personalInfo1.set座机号码("1234-5678");
		personalInfo1.set性别("女");
		personalInfo1.set手机号码("183xxxx6292");
		personalInfo1.set教育背景("本科");
		personalInfo1.set部门(new 部门类型());
		student2.set基本信息(personalInfo2);
		student2.set年级("大二");
		student2.set课程成绩列表(new 课程成绩列表类型());
	}

	// 情景一 ：学生登录成功，查看学生信息和成绩信息都成功，查看不存在的时候报错，但是想要修改时出错，提示权限不够的情况
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
			System.out.println("登录成功，身份：" + user.getIdentity());
		} catch (ParamNullException e) {
			e.printStackTrace();
		} catch (EmailPwdException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("学号179：" + service2.queryInfo("141250179"));

		} catch (InvalidStudentId e) {
			System.err.println(e.getFaultInfo());
		}
	}

	// 情景四 ：登录错误
	@Test
	public void test4() {
		try {
			UserEntity user1 = service1.login("teacher@smail.nju.edu.cn", "12");
		} catch (ParamNullException e) {
			System.err.println("参数为空");
		} catch (EmailPwdException e) {
			System.err.println("密码或邮箱有误");
		}
		try {
			UserEntity user2 = service1.login("teacher@smail.nju.edu.cn", "");
		} catch (ParamNullException e) {
			System.err.println("参数为空");
		} catch (EmailPwdException e) {
			System.err.println("密码或邮箱有误");
		}
	}

}
