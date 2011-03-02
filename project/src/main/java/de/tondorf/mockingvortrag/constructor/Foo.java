package de.tondorf.mockingvortrag.constructor;

public class Foo {
	public Foo() {
		if (!MyFrameworkMegaUtil.isFrameworkProperlyInitialized()) {
			MyFrameworkMegaUtil.initializeFramework();
		}
	}

	public int sum(final int x, final int y) {
		return x + y;
	}
}
