package states;

public class State {
	private long started;

	public State() {
		setStarted(System.currentTimeMillis());
	}

	public long getStarted() {
		return started;
	}

	public void setStarted(long started) {
		this.started = started;
	}
}
