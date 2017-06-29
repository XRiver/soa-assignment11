package cn.edu.nju.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

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
				//TODO Message sent
				System.out.println("Got identity:"+header.getAttribute("value"));
				return true;
				
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
		// TODO Auto-generated method stub
		return null;
	}

}
