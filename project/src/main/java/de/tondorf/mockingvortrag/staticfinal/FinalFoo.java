package de.tondorf.mockingvortrag.staticfinal;

public class FinalFoo {

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
