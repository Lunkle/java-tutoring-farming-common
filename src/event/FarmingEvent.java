package event;

import java.io.Serializable;

public abstract class FarmingEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -775735702158930985L;
	private long id;
	private long timestamp;
	private String[] extraMessages = new String[0];

	public FarmingEvent(long id) {
		this.id = id;
		timestamp = System.currentTimeMillis();
	}

	public FarmingEvent(long id, String[] extraMessages) {
		this(id);
		this.extraMessages = extraMessages;
	}

	public String getDescription() {
		String description = doGetDescription();
		for (String s : extraMessages) {
			description += s;
		}
		return description;
	}

	protected abstract String doGetDescription();

	public long getId() {
		return id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setExtraMessages(String[] extraMessages) {
		this.extraMessages = extraMessages;
	}

	@Override
	public String toString() {
		return getDescription();
	}
}
