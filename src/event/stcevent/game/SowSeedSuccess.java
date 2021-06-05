package event.stcevent.game;

import event.stcevent.STCEvent;

public class SowSeedSuccess extends STCEvent {

	private static final long serialVersionUID = -805833691612948920L;
	private String plantName;

	public SowSeedSuccess(long id, long respondingTo, String plantName) {
		super(id, respondingTo);
		this.plantName = plantName;
	}

	@Override
	public String getDescription() {
		return "Successfully sowed a " + plantName + " seed.";
	}

}
