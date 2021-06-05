package event.stcevent.login;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginFail extends STCEvent implements Serializable {

	private static final long serialVersionUID = -3454063514728355991L;

	public LoginFail(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String getDescription() {
		return "Failed login";
	}

}
