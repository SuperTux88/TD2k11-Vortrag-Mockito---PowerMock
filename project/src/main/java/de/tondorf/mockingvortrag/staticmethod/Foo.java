package de.tondorf.mockingvortrag.staticmethod;

public class Foo {
	public int testMe() {
		final int sth = sth();
		final int y = DrEvil.getEvil(sth);
		return sth + y;
	}

	// ...

	private int sth() {
		return 0;
	}
}
