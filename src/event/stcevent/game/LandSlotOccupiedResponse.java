package event.stcevent.game;

import event.stcevent.STCEvent;

public class LandSlotOccupiedResponse extends STCEvent {

	private static final long serialVersionUID = 3753515636312028636L;

	public LandSlotOccupiedResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	protected String doGetDescription() {
		return "Land slot occupied";
	}

}
