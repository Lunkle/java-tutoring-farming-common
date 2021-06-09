package event.stcevent.session;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LoginSuccessResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -5007895136739914412L;

	public LoginSuccessResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String doGetDescription() {
		return "Successful login";
	}

}
