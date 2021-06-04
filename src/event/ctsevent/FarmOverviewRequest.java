package event.ctsevent;

public class FarmOverviewRequest extends CTSEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8166130717313863259L;

	@Override
	public String getDescription() {
		return "Fetching farm overview";
	}

}
