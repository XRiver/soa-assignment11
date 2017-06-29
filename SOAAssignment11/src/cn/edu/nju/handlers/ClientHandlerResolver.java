package cn.edu.nju.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class ClientHandlerResolver implements HandlerResolver{

	SOAPHeaderAppendHandler appendHandler = new SOAPHeaderAppendHandler();
	SOAPHeaderCheckHandler checkHandler = new SOAPHeaderCheckHandler();
	SOAPMessagePersistenceHandler persistenceHandler = new SOAPMessagePersistenceHandler();
	
	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlers = new ArrayList<>();
		handlers.add(appendHandler);
		handlers.add(checkHandler);
		handlers.add(persistenceHandler);
		return handlers;
	}

}
