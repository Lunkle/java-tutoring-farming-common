package event.stcevent;

import java.io.Serializable;

import event.FarmingEvent;

/**
 * A server to client event.
 * 
 * @author Jay
 *
 */
public abstract class STCEvent extends FarmingEvent implements Serializable {

	private static final long serialVersionUID = 7173108490018255365L;
	private long respondingTo;

	public STCEvent(long id, long respondingTo) {
		super(id);
		this.respondingTo = respondingTo;
	}

	public long getRespondingTo() {
		return respondingTo;
	}

}
