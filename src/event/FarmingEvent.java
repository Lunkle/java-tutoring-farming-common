package event;

import java.io.Serializable;

public abstract class FarmingEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -775735702158930985L;
	private long timestamp;

	public FarmingEvent() {
		timestamp = System.currentTimeMillis();
	}

	public abstract String getDescription();

	public long getTimestamp() {
		return timestamp;
	}

}
