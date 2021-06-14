package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopSlotAlreadySoldResponse extends STCEvent {

	private static final long serialVersionUID = 5007241263184663675L;

	public ShopSlotAlreadySoldResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Items already finished selling";
	}

}
