package event.stcevent.game;

import event.stcevent.STCEvent;

public class TradeSlotEmptyResponse extends STCEvent {

	private static final long serialVersionUID = 1812728810827056576L;

	public TradeSlotEmptyResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Trade slot empty";
	}

}
