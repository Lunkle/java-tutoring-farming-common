package event.stcevent.game;

import event.stcevent.STCEvent;

public class InvalidAmountResponse extends STCEvent {

	private static final long serialVersionUID = -5822801999468381750L;

	public InvalidAmountResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Invalid amount";
	}

}
