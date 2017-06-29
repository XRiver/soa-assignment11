
package cn.edu.nju.score_manage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nju.score_manage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _基本信息_QNAME = new QName("http://www.nju.edu.cn/schema", "\u57fa\u672c\u4fe1\u606f");
    private final static QName _部门_QNAME = new QName("http://www.nju.edu.cn/schema", "\u90e8\u95e8");
    private final static QName _分数错误_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5206\u6570\u9519\u8bef");
    private final static QName _学号_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7");
    private final static QName _学号课程号_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7\u8bfe\u7a0b\u53f7");
    private final static QName _学号错误_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7\u9519\u8bef");
    private final static QName _学生_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u751f");
    private final static QName _排序方式_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u6392\u5e8f\u65b9\u5f0f");
    private final static QName _课程_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b");
    private final static QName _课程成绩_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u6210\u7ee9");
    private final static QName _课程成绩列表_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868");
    private final static QName _课程编号_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u7f16\u53f7");
    private final static QName _课程编号错误_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u7f16\u53f7\u9519\u8bef");
    private final static QName _排序_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u6392\u5e8f");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.score_manage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link 个人信息类型 }
     * 
     */
    public 个人信息类型 create个人信息类型() {
        return new 个人信息类型();
    }

    /**
     * Create an instance of {@link 部门类型 }
     * 
     */
    public 部门类型 create部门类型() {
        return new 部门类型();
    }

    /**
     * Create an instance of {@link 个人基本信息类型 }
     * 
     */
    public 个人基本信息类型 create个人基本信息类型() {
        return new 个人基本信息类型();
    }

    /**
     * Create an instance of {@link 地址类型 }
     * 
     */
    public 地址类型 create地址类型() {
        return new 地址类型();
    }

    /**
     * Create an instance of {@link 学号课程号类型 }
     * 
     */
    public 学号课程号类型 create学号课程号类型() {
        return new 学号课程号类型();
    }

    /**
     * Create an instance of {@link 课程成绩列表类型 }
     * 
     */
    public 课程成绩列表类型 create课程成绩列表类型() {
        return new 课程成绩列表类型();
    }

    /**
     * Create an instance of {@link 课程成绩类型 }
     * 
     */
    public 课程成绩类型 create课程成绩类型() {
        return new 课程成绩类型();
    }

    /**
     * Create an instance of {@link 成绩类型 }
     * 
     */
    public 成绩类型 create成绩类型() {
        return new 成绩类型();
    }

    /**
     * Create an instance of {@link 排序类型 }
     * 
     */
    public 排序类型 create排序类型() {
        return new 排序类型();
    }

    /**
     * Create an instance of {@link 学生信息 }
     * 
     */
    public 学生信息 create学生信息() {
        return new 学生信息();
    }

    /**
     * Create an instance of {@link 课程信息 }
     * 
     */
    public 课程信息 create课程信息() {
        return new 课程信息();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 个人信息类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u57fa\u672c\u4fe1\u606f")
    public JAXBElement<个人信息类型> create基本信息(个人信息类型 value) {
        return new JAXBElement<个人信息类型>(_基本信息_QNAME, 个人信息类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 部门类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u90e8\u95e8")
    public JAXBElement<部门类型> create部门(部门类型 value) {
        return new JAXBElement<部门类型>(_部门_QNAME, 部门类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5206\u6570\u9519\u8bef")
    public JAXBElement<String> create分数错误(String value) {
        return new JAXBElement<String>(_分数错误_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7")
    public JAXBElement<String> create学号(String value) {
        return new JAXBElement<String>(_学号_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 学号课程号类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7\u8bfe\u7a0b\u53f7")
    public JAXBElement<学号课程号类型> create学号课程号(学号课程号类型 value) {
        return new JAXBElement<学号课程号类型>(_学号课程号_QNAME, 学号课程号类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7\u9519\u8bef")
    public JAXBElement<String> create学号错误(String value) {
        return new JAXBElement<String>(_学号错误_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 学生信息 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u751f")
    public JAXBElement<学生信息> create学生(学生信息 value) {
        return new JAXBElement<学生信息>(_学生_QNAME, 学生信息.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 排序方式类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u6392\u5e8f\u65b9\u5f0f")
    public JAXBElement<排序方式类型> create排序方式(排序方式类型 value) {
        return new JAXBElement<排序方式类型>(_排序方式_QNAME, 排序方式类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 课程信息 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b")
    public JAXBElement<课程信息> create课程(课程信息 value) {
        return new JAXBElement<课程信息>(_课程_QNAME, 课程信息.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 课程成绩类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u6210\u7ee9")
    public JAXBElement<课程成绩类型> create课程成绩(课程成绩类型 value) {
        return new JAXBElement<课程成绩类型>(_课程成绩_QNAME, 课程成绩类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 课程成绩列表类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868")
    public JAXBElement<课程成绩列表类型> create课程成绩列表(课程成绩列表类型 value) {
        return new JAXBElement<课程成绩列表类型>(_课程成绩列表_QNAME, 课程成绩列表类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u7f16\u53f7")
    public JAXBElement<String> create课程编号(String value) {
        return new JAXBElement<String>(_课程编号_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u7f16\u53f7\u9519\u8bef")
    public JAXBElement<String> create课程编号错误(String value) {
        return new JAXBElement<String>(_课程编号错误_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 排序类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u6392\u5e8f")
    public JAXBElement<排序类型> create排序(排序类型 value) {
        return new JAXBElement<排序类型>(_排序_QNAME, 排序类型.class, null, value);
    }

}
