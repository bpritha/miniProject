package mode;

public class User {
	String userName;
	String name;
	String password;
	int type;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(String userName,String password , String name, int userType) {
		
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.type = userType;
	}
	

}
