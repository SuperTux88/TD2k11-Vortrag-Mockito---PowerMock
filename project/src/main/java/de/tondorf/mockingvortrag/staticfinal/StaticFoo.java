package de.tondorf.mockingvortrag.staticfinal;

public class StaticFoo {

	public int testStatic() {
		final int sth = sth();
		final int y = DrEvil.getEvil(sth);
		return sth + y;
	}

	private int sth() {
		return 0;
	}

	// ...
}
