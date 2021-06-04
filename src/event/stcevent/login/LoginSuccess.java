package event.stcevent.login;

import event.stcevent.STCEvent;

public class LoginSuccess extends STCEvent {

	@Override
	public String getDescription() {
		return "Successful login";
	}

}
