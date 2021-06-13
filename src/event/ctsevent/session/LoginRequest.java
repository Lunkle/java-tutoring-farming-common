package event.ctsevent.session;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class LoginRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = 1607145290079077398L;
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
	protected String doGetDescription() {
		return "Attempting login";
	}

}
