package event.ctsevent;

import java.io.Serializable;

public class FarmOverviewRequest extends CTSEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5736056546837007817L;

	public FarmOverviewRequest(long id) {
		super(id);
	}

	@Override
	public String getDescription() {
		return "Fetching farm overview";
	}

}
