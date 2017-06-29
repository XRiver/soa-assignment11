package cn.edu.nju.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import cn.edu.nju.common.States;

public class SOAPHeaderAppendHandler implements SOAPHandler<SOAPMessageContext> {

	public boolean handleMessage(SOAPMessageContext context) {
		try {
			context.getMessage().getSOAPHeader().addNamespaceDeclaration("client", "http://soa/");
			Iterator iter = context.getMessage().getSOAPHeader().getChildElements();
			boolean hasIdentity = false;
			while(iter.hasNext()) {
				SOAPElement header = (SOAPElement)iter.next();
				if (header.getElementName().getLocalName().equals("logId")) {
					hasIdentity = true;
					break;
				}
			}
			
			if (!hasIdentity) {
				SOAPElement idElement = context.getMessage().getSOAPHeader().addChildElement("logID","client");
				idElement.addAttribute(new QName("value"),""+States.getIdentity().getId());
			}
			
		} catch (SOAPException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
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

}
