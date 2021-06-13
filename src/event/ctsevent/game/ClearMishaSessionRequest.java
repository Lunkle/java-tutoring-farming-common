package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ClearMishaSessionRequest extends CTSEvent {

	private static final long serialVersionUID = 6132946990967190250L;

	public ClearMishaSessionRequest(long id) {
		super(id);
	}

	@Override
	protected String doGetDescription() {
		return "Clear misha sessions";
	}

}
