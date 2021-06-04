package farm;

import java.io.Serializable;
import java.util.List;

public class Farm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4689626955722675202L;

	private List<LandSlot> landSlots;

	public List<LandSlot> getLandSlots() {
		return landSlots;
	}

}
