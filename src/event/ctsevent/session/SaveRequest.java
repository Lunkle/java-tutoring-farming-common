package event.ctsevent.session;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class SaveRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = -876043311513972309L;

	public SaveRequest(long id) {
		super(id);
	}

	@Override
	public String getDescription() {
		return "Saving";
	}

}
