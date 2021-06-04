package event;

import java.io.Serializable;

public abstract class FarmingEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -775735702158930985L;
	private long id;
	private long timestamp;

	public FarmingEvent(long id) {
		this.id = id;
		timestamp = System.currentTimeMillis();
	}

	public abstract String getDescription();

	public long getId() {
		return id;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
