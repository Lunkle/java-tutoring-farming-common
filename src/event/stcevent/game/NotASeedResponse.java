package event.stcevent.game;

import event.stcevent.STCEvent;

public class NotASeedResponse extends STCEvent {

	private static final long serialVersionUID = 4305129667181519465L;

	public NotASeedResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Tried to plant item that was not a seed";
	}

}
