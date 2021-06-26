package event.stcevent.game;

import event.stcevent.STCEvent;

public class NotEnoughItemsResponse extends STCEvent {

	private static final long serialVersionUID = 8536012096209939633L;

	public NotEnoughItemsResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Not enough items";
	}

}
