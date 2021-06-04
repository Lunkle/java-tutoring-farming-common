package event.stcevent.login;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginFail extends STCEvent implements Serializable {

	private static final long serialVersionUID = -4222325293475789579L;

	private long respondingTo;

	public LoginFail(long id, long respondingTo) {
		super(id);
		this.respondingTo = respondingTo;
	}

	public long getRespondingTo() {
		return respondingTo;
	}

	@Override
	public String getDescription() {
		return "Failed login";
	}

}
