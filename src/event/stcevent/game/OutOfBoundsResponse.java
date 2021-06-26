package event.stcevent.game;

public class OutOfBoundsResponse extends TextResponse{
	
	private static final long serialVersionUID = -54056039154817074L;

	public OutOfBoundsResponse(long id, long respondingTo, String slotType, int row, int col) {
		super(id,respondingTo,slotType + " index (row:" + row + " ,col: " + col + ") is out of bounds.");
	}
}
