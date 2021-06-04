package event.stcevent;

import java.io.Serializable;

import event.FarmingEvent;

public abstract class STCEvent extends FarmingEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2714438404331311L;

	public STCEvent(long id) {
		super(id);
	}

}
