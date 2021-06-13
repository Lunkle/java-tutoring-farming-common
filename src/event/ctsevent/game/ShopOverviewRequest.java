package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ShopOverviewRequest extends CTSEvent {

	private static final long serialVersionUID = 4287075609554902733L;

	public ShopOverviewRequest(long id) {
		super(id);
	}

	@Override
	protected String doGetDescription() {
		return "Getting shop overview";
	}

}
