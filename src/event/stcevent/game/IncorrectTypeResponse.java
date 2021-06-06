package event.stcevent.game;

import event.stcevent.STCEvent;

public class IncorrectTypeResponse extends STCEvent {

	private static final long serialVersionUID = 8179992435185953874L;

	public IncorrectTypeResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String getDescription() {
		return "Incorrect type";
	}

}
