package cn.edu.nju.common;

public enum UserIdentity {
LOGGED_OUT("logged_out",1),TEACHER("teacher",2),STUDENT("student",3),NONE("none",4);
	
	private String name;
	private int idNum;
	
	UserIdentity(String name, int idNum) {
		this.name = name;
		this.idNum = idNum;
	}
	
	public int getId() {
		return idNum;
	}
	
	public static UserIdentity fromId(int id) {
		for (UserIdentity identity: UserIdentity.values()) {
			if (identity.idNum==id) {
				return identity;
			}
		}
		return LOGGED_OUT;
	}
	
}
