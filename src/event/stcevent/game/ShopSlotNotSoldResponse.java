package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopSlotNotSoldResponse extends STCEvent {

	private static final long serialVersionUID = -7220037546824286795L;

	public ShopSlotNotSoldResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Items not finished selling";
	}

}
