package de.tondorf.mockingvortrag.staticfinal;

public class Foo {

	// static
	public int testStatic() {
		final int sth = sth();
		final int y = DrEvil.getEvil(sth);
		return sth + y;
	}

	private int sth() {
		return 0;
	}

	// ...

	// final
	private MyCoolLibrary lib;

	public void setLib(final MyCoolLibrary lib) {
		this.lib = lib;
	}

	public void testFinal() {
		lib.doFinal();
		// ...
	}

	// ...
}
