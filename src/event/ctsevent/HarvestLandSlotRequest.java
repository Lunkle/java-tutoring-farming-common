package event.ctsevent;

import java.io.Serializable;

public class HarvestLandSlotRequest extends CTSEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2827404747457674501L;
	private int index;

	public HarvestLandSlotRequest(long id, int index) {
		super(id);
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String getDescription() {
		return "Harvesting land slot " + index;
	}

}
