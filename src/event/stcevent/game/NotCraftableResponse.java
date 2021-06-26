package event.stcevent.game;

import event.stcevent.STCEvent;

public class NotCraftableResponse extends STCEvent {

	private static final long serialVersionUID = -3959637253190804452L;

	public NotCraftableResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Item cannot be crafted";
	}

}
