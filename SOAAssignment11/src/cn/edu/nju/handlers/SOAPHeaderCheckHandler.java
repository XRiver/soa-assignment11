package cn.edu.nju.handlers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import cn.edu.nju.common.ServiceTypes;
import cn.edu.nju.common.States;
import cn.edu.nju.common.UserIdentity;

public class SOAPHeaderCheckHandler implements SOAPHandler<SOAPMessageContext> {


	public boolean handleMessage(SOAPMessageContext context) {
		try {
			Iterator iter = context.getMessage().getSOAPHeader().getChildElements();
			boolean hasIdentity = false;
			SOAPElement header = null;
			while(iter.hasNext()) {
				header = (SOAPElement)iter.next();
				if (header.getElementName().getLocalName().equals("logID")) {
					hasIdentity = true;
					break;
				}
			}
			
			if (hasIdentity) {
				//Message sent
				UserIdentity identity = UserIdentity.fromId(Integer.parseInt(header.getAttribute("value")));
				System.out.println("Got identity:"+identity);
				ServiceTypes serType = States.getServiceType();
				
				if (serType==ServiceTypes.LOG_IN) {
					hintCheck(serType, identity, true);
					return true;
				}
				
				ServiceTypes[] permits = null;
				switch(identity) {
				case LOGGED_OUT:
				case NONE:
					hintCheck(serType, identity, false);
					return false;
				case STUDENT:
					permits = new ServiceTypes[]{
							ServiceTypes.QUERY_INFO,
							ServiceTypes.QUERY_GRADE
					};
					if (Arrays.asList(permits).contains(serType)) {
						hintCheck(serType, identity, true);
						return true;
					} else {
						hintCheck(serType, identity, false);
						return false;
					}
				case TEACHER:
					permits = ServiceTypes.values();
					if (Arrays.asList(permits).contains(serType)) {
						hintCheck(serType, identity, true);
						return true;
					} else {
						hintCheck(serType, identity, false);
						return false;
					}
				default:
					System.out.println("ERROR: failed to parse user identity");
					return false;
				}
								
			} else {
				// Message back
				return true;
			}
			
		} catch (SOAPException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}


	@Override
	public void close(MessageContext context) {}



	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	private void hintCheck(ServiceTypes serType, UserIdentity id, boolean permitted) {
		System.out.println("Service "+serType+" "+(permitted?"PERMITTED":"FORBIDDEN")+" for identity "+id.name());
	}

}
