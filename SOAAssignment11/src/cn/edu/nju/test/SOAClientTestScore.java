package cn.edu.nju.test;

import org.junit.Before;
import org.junit.Test;

import cn.edu.nju.login.EmailPwdException;
import cn.edu.nju.login.ParamNullException;
import cn.edu.nju.login.UserEntity;
import cn.edu.nju.login.UserService;
import cn.edu.nju.score_manage.InvalidCourseId;
import cn.edu.nju.score_manage.InvalidScore;
import cn.edu.nju.score_manage.InvalidStudentId;
import cn.edu.nju.score_manage.ScoreManageService;
import cn.edu.nju.score_manage.学号课程号类型;
import cn.edu.nju.score_manage.课程成绩列表类型;
import cn.edu.nju.student_info.DataFormatError;
import cn.edu.nju.wrapservice.ScoreManagementServiceWrapper;
import cn.edu.nju.wrapservice.UserServiceWrapper;

public class SOAClientTestScore {
	UserService service1;
	ScoreManageService service2;

	@Before
	public void init() {
		service1 = UserServiceWrapper.getInstance();
		service2 = ScoreManagementServiceWrapper.getInstance();
	}

	// 情景一 ：学生登录成功，查看学生信息和成绩信息都成功，查看不存在的时候报错，但是想要修改时出错，提示权限不够的情况
	@Test
	public void test1() {
		UserEntity user = null;
		try {
			user = service1.login("student@smail.nju.edu.cn", "123");
			System.out.println("登录成功，身份是" + user.getIdentity());
		} catch (ParamNullException e) {
			e.printStackTrace();
		} catch (EmailPwdException e) {
			e.printStackTrace();
		}
		try {
			课程成绩列表类型 list = service2.queryGrade("141250179");
			System.out.println("查询成功，信息如下");
			System.out.println(list);
		} catch (InvalidStudentId e) {
			e.printStackTrace();
		}
		try {
			service2.deleteGrade(new 学号课程号类型("14120179", "10002"));
		} catch (InvalidCourseId e) {
			e.printStackTrace();
		} catch (InvalidStudentId e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.err.println("你的身份是" + user.getIdentity() + "，权限不够，不能执行删除操作");
		}
	}

	// 情景二 ：老师登录成功，对成绩信息进行操作，除非查询不存在的学号，否则都成功
	@Test
	public void test2() {
		// 登录
		try {
			UserEntity user = service1.login("teacher@smail.nju.edu.cn", "123");
			System.out.println("登录成功，身份：" + user.getIdentity());
		} catch (ParamNullException e) {
			e.printStackTrace();
		} catch (EmailPwdException e) {
			e.printStackTrace();
		}
		// 查正确学号，重点关注第一门课的成绩
		try {
			课程成绩列表类型 list = service2.queryGrade("141250179");
			System.out.println("查询成功，信息如下");
			System.out.println("第一门课的总评成绩是：" + list.get课程成绩().get(0).get成绩().get(0).get得分());
		} catch (InvalidStudentId e) {
			System.out.println("查询出错，学生id不存在");
		}
		// 查错误学号
		try {
			课程成绩列表类型 list = service2.queryGrade("141250123");
			System.out.println("查询成功，信息如下");
			System.out.println(list);
		} catch (InvalidStudentId e) {
			System.err.println("查询出错，学生id不存在");
		}
		// 改
		try {
			课程成绩列表类型 list = service2.queryGrade("141250179");
			list.get课程成绩().get(0).get成绩().get(0).set得分(80);
			service2.modifyGrade(list.get课程成绩().get(0));
			System.out.println("修改成功，再次查询");
			list = service2.queryGrade("141250179");
			System.out.println("查询成功，信息如下");
			System.out.println("第一门课的总评成绩是：" + list.get课程成绩().get(0).get成绩().get(0).get得分());
		} catch (InvalidStudentId e) {
			e.printStackTrace();
		} catch (InvalidCourseId e) {
			e.printStackTrace();
		} catch (InvalidScore e) {
			e.printStackTrace();
		}
		//  删，出错情况
		try {
			service2.deleteGrade(new 学号课程号类型("141250123","10002"));
		} catch (InvalidStudentId e) {
			System.err.println("学生id无效");
		} catch (InvalidCourseId e) {
			System.err.println("课程id无效");
		} 
	}

	// 情景三 ：无权限者登录成功，不论是查看还是修改均失败，提示权限不够
	@Test
	public void test3() {
		UserEntity user = null;
		try {
			user = service1.login("none@smail.nju.edu.cn", "123");
			System.out.println("登录成功，身份：" + user.getIdentity());
		} catch (ParamNullException e) {
			e.printStackTrace();
		} catch (EmailPwdException e) {
			e.printStackTrace();
		}
		try {
			service2.queryGrade("141250179");
		} catch (InvalidStudentId e) {
			System.err.println(e.getFaultInfo());
		} catch (RuntimeException e) {
			System.err.println("你的身份是" + user.getIdentity() + "，权限不够，不能执行查询操作");
		}
		try {
			service2.deleteGrade(new 学号课程号类型("14120179", "10002"));
		} catch (InvalidCourseId e) {
			e.printStackTrace();
		} catch (InvalidStudentId e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.err.println("你的身份是" + user.getIdentity() + "，权限不够，不能执行删除操作");
		}

	}
	
	//情景四:不登录查询，权限错误
	@Test
	public void test4() {
		try {
			service2.queryGrade("141250179");
		} catch (InvalidStudentId e) {
			System.err.println(e.getFaultInfo());
		} catch (RuntimeException e) {
			System.err.println("你未登录，权限不够，不能执行查询操作");
		}
	}

	// 情景五：登录错误
	@Test
	public void test5() {
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
