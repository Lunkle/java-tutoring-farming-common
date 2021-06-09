package event.stcevent.game;

public class FailResponse extends TextResponse {

	private static final long serialVersionUID = -1863762992254849584L;

	public FailResponse(long id, long respondingTo, String failReason) {
		super(id, respondingTo, failReason);
	}

}
