package InterfacesEnums;

public enum BookPriority {

	INVALUABLE(3), // most important
	HIGHLYSIGNIFICANT(2), // second most important
	NOTEWORTHY(1); // least important

	private final int priority;

	private BookPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}
}
