package cn.edu.nju.login;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2017-06-28T22:24:41.796+08:00
 * Generated source version: 3.1.11
 * 
 */
@WebService(targetNamespace = "http://service.student.nju.edu/", name = "UserService")
@XmlSeeAlso({ObjectFactory.class})
public interface UserService {

    @WebMethod
    @RequestWrapper(localName = "login", targetNamespace = "http://service.student.nju.edu/", className = "cn.edu.nju.login.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://service.student.nju.edu/", className = "cn.edu.nju.login.LoginResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cn.edu.nju.login.UserEntity login(
        @WebParam(name = "email", targetNamespace = "")
        java.lang.String email,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    ) throws ParamNullException, EmailPwdException;
}