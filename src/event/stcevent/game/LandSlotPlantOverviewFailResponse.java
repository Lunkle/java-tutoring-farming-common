package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LandSlotPlantOverviewFailResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -4454796821747924108L;
	private String reason;

	public LandSlotPlantOverviewFailResponse(long id, long respondingTo, String reason) {
		super(id, respondingTo);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String getDescription() {
		return "Failed to get plant overview response because " + reason;
	}

}
