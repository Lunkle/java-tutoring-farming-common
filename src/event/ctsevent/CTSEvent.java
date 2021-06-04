package event.ctsevent;

import java.io.Serializable;

import event.FarmingEvent;

public abstract class CTSEvent extends FarmingEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3235593244635539807L;

	public CTSEvent(long id) {
		super(id);
	}
}
