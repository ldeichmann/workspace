import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

	private List<Password> list = new ArrayList<Password>();
	private List<Password> decryptedList = new ArrayList<Password>();
	
	public void addPassword(Password pw) {
		this.list.add(pw);
	}
	
	public void addDecPassword(Password pw) {
		this.decryptedList.add(pw);
	}
	
	public Password getPassword() {
		if (this.list.size() > 0) {
			return this.list.remove(0);
		} else {
			return null;
		}
	}
	
	public List<Password> getDecryptedList() {
		return this.decryptedList;
	}

}
