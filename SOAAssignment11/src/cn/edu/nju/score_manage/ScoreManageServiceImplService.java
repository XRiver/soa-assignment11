package cn.edu.nju.score_manage;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2017-06-28T20:05:40.342+08:00
 * Generated source version: 3.1.11
 * 
 */
@WebServiceClient(name = "ScoreManageServiceImplService", 
                  wsdlLocation = "http://106.15.91.25:8080/grade/cxf/scoreManageService?wsdl",
                  targetNamespace = "http://jw.nju.edu.cn/wsdl") 
public class ScoreManageServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://jw.nju.edu.cn/wsdl", "ScoreManageServiceImplService");
    public final static QName ScoreManageServicePort = new QName("http://jw.nju.edu.cn/wsdl", "ScoreManageServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://106.15.91.25:8080/grade/cxf/scoreManageService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ScoreManageServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://106.15.91.25:8080/grade/cxf/scoreManageService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ScoreManageServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ScoreManageServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ScoreManageServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ScoreManageServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ScoreManageServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ScoreManageServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ScoreManageService
     */
    @WebEndpoint(name = "ScoreManageServicePort")
    public ScoreManageService getScoreManageServicePort() {
        return super.getPort(ScoreManageServicePort, ScoreManageService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ScoreManageService
     */
    @WebEndpoint(name = "ScoreManageServicePort")
    public ScoreManageService getScoreManageServicePort(WebServiceFeature... features) {
        return super.getPort(ScoreManageServicePort, ScoreManageService.class, features);
    }

}
