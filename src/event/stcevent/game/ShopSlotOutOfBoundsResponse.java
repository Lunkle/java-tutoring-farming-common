package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopSlotOutOfBoundsResponse extends STCEvent {

	private static final long serialVersionUID = 5007241263184663675L;

	public ShopSlotOutOfBoundsResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Shop slot out of bounds";
	}

}
