
package cn.edu.nju.login;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.11
 * 2017-06-28T22:24:41.774+08:00
 * Generated source version: 3.1.11
 */

@WebFault(name = "String", targetNamespace = "http://service.student.nju.edu/")
public class ParamNullException extends Exception {
    
    private java.lang.String string;

    public ParamNullException() {
        super();
    }
    
    public ParamNullException(String message) {
        super(message);
    }
    
    public ParamNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamNullException(String message, java.lang.String string) {
        super(message);
        this.string = string;
    }

    public ParamNullException(String message, java.lang.String string, Throwable cause) {
        super(message, cause);
        this.string = string;
    }

    public java.lang.String getFaultInfo() {
        return this.string;
    }
}