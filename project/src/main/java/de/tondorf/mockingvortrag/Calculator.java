package de.tondorf.mockingvortrag;

import org.apache.log4j.Logger;

public class Calculator {
	private static final Logger LOG = Logger.getLogger(Calculator.class);

	public int sum(int x, int y) {
		LOG.debug("Calculating sum of " + x + " and " + y);
		return x + y;
	}
}
