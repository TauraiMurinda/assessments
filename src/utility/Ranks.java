package utility;

public enum Ranks {
	ACE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
	JACK("11"), QUEEN("12"), KING("13");

	@Override
	public String toString() {
		return rank;
	}

	private Ranks(String rank) {
		this.rank = rank;
	}

	private final String rank;

}
