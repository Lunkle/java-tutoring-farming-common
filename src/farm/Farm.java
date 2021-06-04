package farm;

import java.io.Serializable;
import java.util.List;

public class Farm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2650213342053182131L;

	private List<LandSlot> landSlots;

	public List<LandSlot> getLandSlots() {
		return landSlots;
	}

	public void setLandSlots(List<LandSlot> landSlots) {
		this.landSlots = landSlots;
	}

}
