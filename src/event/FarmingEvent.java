package event;

public abstract class FarmingEvent {

	private long timestamp;
	
	public FarmingEvent() {
		timestamp = System.currentTimeMillis();
	}
	
	public abstract String getDescription();

	public long getTimestamp() {
		return timestamp;
	}

}
