package event.stcevent.session;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginFailResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = 3126768662700041239L;
	private String reason;

	public LoginFailResponse(long id, long respondingTo, String reason) {
		super(id, respondingTo);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String doGetDescription() {
		return "Failed login because " + reason;
	}

}
