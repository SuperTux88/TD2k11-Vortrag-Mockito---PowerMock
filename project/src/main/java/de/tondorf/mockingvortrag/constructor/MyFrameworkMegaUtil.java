package de.tondorf.mockingvortrag.constructor;

import org.apache.log4j.Logger;

public class MyFrameworkMegaUtil {
	private static final Logger LOG = Logger
			.getLogger(MyFrameworkMegaUtil.class);

	public static boolean isFrameworkProperlyInitialized() {
		LOG.debug("isFrameworkProperlyInitialized");
		return false;
	}

	public static void initializeFramework() {
		LOG.debug("initializeFramework");
	}
}
