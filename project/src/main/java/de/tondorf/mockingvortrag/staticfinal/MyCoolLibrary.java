package de.tondorf.mockingvortrag.staticfinal;

import org.apache.log4j.Logger;

public final class MyCoolLibrary {

	public void doFinal() {
		Logger.getLogger(getClass()).debug("doFinal");
	}
}
