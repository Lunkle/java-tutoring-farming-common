package event.ctsevent.session;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class CloseSessionRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = -1056843110038726974L;

	public CloseSessionRequest(long id) {
		super(id);
	}

	@Override
	public String getDescription() {
		return "Ending Session";
	}

}
