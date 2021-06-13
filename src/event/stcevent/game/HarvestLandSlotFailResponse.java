package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class HarvestLandSlotFailResponse extends STCEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8292781365415822512L;
	private String failMessage;

	public HarvestLandSlotFailResponse(long id, long respondingTo, String failMessage) {
		super(id, respondingTo);
		this.failMessage = failMessage;
	}

	public String getFailMessage() {
		return failMessage;
	}

	@Override
	protected String doGetDescription() {
		return "Could not harvest because " + failMessage;
	}

}
