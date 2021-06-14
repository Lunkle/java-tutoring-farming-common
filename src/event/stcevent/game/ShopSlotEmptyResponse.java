package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopSlotEmptyResponse extends STCEvent {

	private static final long serialVersionUID = 1066467777854637580L;

	public ShopSlotEmptyResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Shop slot empty";
	}

}
