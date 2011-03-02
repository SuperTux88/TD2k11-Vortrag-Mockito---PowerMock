package de.tondorf.mockingvortrag;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareOnlyThisForTest({ Logger.class })
@RunWith(PowerMockRunner.class)
public class CalculatorTest {

	private Calculator calculator;
	private Logger loggerMock;

	@Before
	public void setup() {
		mockStatic(Logger.class);

		loggerMock = mock(Logger.class);
		when(Logger.getLogger(Calculator.class)).thenReturn(loggerMock);

		calculator = new Calculator();
	}

	@Test
	public void testSum() {
		final int result = calculator.sum(1, 1);
		assertEquals(2, result);
		verify(loggerMock, times(1)).debug(anyString());
	}
}
