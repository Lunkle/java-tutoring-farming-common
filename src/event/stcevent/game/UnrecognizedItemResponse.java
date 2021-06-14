package event.stcevent.game;

import event.stcevent.STCEvent;

public class UnrecognizedItemResponse extends STCEvent {

	private static final long serialVersionUID = 1323999788096023588L;

	public UnrecognizedItemResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Unrecognized Item";
	}

}
