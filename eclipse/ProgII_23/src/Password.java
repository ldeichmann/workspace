
public class Password {

	private String encPassword;
	private String username;
	private String password;
	private long time;
	
	public Password(String username, String encPassword) {
		this.encPassword = encPassword;
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEncPassword() {
		return this.encPassword;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public long getTime() {
		return this.time;
	}
	
	
	
}
