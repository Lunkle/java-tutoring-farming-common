package event;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import event.stcevent.STCEvent;

/**
 * A singleton object that can deserialize bytes into an event.
 * 
 * @author Jay
 *
 */
public class EventSerializer {

	private static EventSerializer instance;

	/**
	 * Gets the instance. Sets the instance to a new EventSerializer if the instance
	 * was previously null.
	 * 
	 * @return the EventSerializer instance
	 */
	public static EventSerializer instance() {
		return instance != null ? instance : (instance = new EventSerializer());
	}

	/**
	 * Private constructor to make sure only {@link #instance() instance()} can make
	 * a new EventSerializer.
	 */
	private EventSerializer() {
	}

	public FarmingEvent deserialize(byte[] data) throws ClassNotFoundException, IOException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(in);
		return (STCEvent) is.readObject();
	}

}
