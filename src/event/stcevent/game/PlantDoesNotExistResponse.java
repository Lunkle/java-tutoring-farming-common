package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class PlantDoesNotExistResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -4454796821747924108L;

	public PlantDoesNotExistResponse(long id, long respondingTo) {
		super(id, respondingTo);
	}

	@Override
	public String doGetDescription() {
		return "Plant does not exist.";
	}

}
