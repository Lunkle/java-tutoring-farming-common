package event.ctsevent.session;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class SaveRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = -876043311513972309L;
	private String username;
	private String password;

	public SaveRequest(long id, String username, String password) {
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
