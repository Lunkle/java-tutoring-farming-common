package event.stcevent.login;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginFail extends STCEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4222325293475789579L;

	public LoginFail(long id) {
		super(id);
	}

	@Override
	public String getDescription() {
		return "Failed login";
	}

}
