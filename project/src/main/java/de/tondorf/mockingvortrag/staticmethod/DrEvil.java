package de.tondorf.mockingvortrag.staticmethod;

import org.apache.log4j.Logger;

public class DrEvil {
	private static final Logger LOG = Logger.getLogger(DrEvil.class);

	public static int getEvil(final int sth) {
		return doReallyEvilStuff();
	}

	private static int doReallyEvilStuff() {
		LOG.debug("doReallyEvilStuff");
		new DrEvil(); // coverage ;-)
		return 0;
	}

}
