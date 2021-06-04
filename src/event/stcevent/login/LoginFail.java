package event.stcevent.login;

import event.stcevent.STCEvent;

public class LoginFail extends STCEvent {

	@Override
	public String getDescription() {
		return "Failed login";
	}

}
