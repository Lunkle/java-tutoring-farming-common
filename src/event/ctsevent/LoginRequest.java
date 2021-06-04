package event.ctsevent;

import java.io.Serializable;

public class LoginRequest extends CTSEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6397067689747766977L;
	private String username;
	private String password;

	public LoginRequest(long id, String username, String password) {
		super(id);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getDescription() {
		return "Attempting login";
	}

}
