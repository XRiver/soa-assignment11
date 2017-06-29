package cn.edu.nju.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPMessagePersistenceHandler implements SOAPHandler<SOAPMessageContext> {

	
	private static OutputStream out = null;
	static {
		File f = new File("SOAPMessages.txt");
		try {
			out = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot persist messages");
			out = System.out;
		}
	}
	
	class NullOutputStream extends OutputStream {
		  @Override
		  public void write(int b) throws IOException {}
	}
	
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("INVOKE PERSIST");
		
		try {
			context.getMessage().writeTo(out);
			out.write('\n');
			out.flush();
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("INVOKE PERSIST FOR FAULT");
		
		try {
			context.getMessage().writeTo(out);
			out.write('\n');
			out.flush();
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public void close(MessageContext context) {}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
