package cn.edu.nju.common;

public class States {

	private static UserIdentity identity = UserIdentity.LOGGED_OUT;
	private static ServiceTypes serviceType = ServiceTypes.LOG_IN; 

	public static UserIdentity getIdentity() {
		return identity;
	}

	public static void setIdentity(UserIdentity identity) {
		States.identity = identity;
	}

	public static ServiceTypes getServiceType() {
		return serviceType;
	}

	public static void setServiceType(ServiceTypes serviceType) {
		States.serviceType = serviceType;
	}
		
}
