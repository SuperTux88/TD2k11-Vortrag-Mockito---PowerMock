package de.tondorf.mockingvortrag;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareOnlyThisForTest({ Logger.class })
@RunWith(PowerMockRunner.class)
public class CalculatorTest {

	private Calculator calculator;
	private static final Logger loggerMock = mock(Logger.class);

	@BeforeClass
	public static void setupClass() {
		mockStatic(Logger.class);

		when(Logger.getLogger(Calculator.class)).thenReturn(loggerMock);
	}

	@Before
	public void setup() {
		reset(loggerMock);
		calculator = new Calculator();
	}

	@Test
	public void testSum() {
		final int result = calculator.sum(2, 3);
		assertEquals(5, result);
		verify(loggerMock, times(1)).debug(anyString());
	}

	@Test
	public void testSumWithNegativeValues() {
		final int result = calculator.sum(-2, -3);
		assertEquals(-5, result);
		verify(loggerMock, times(1)).debug(anyString());
	}

	@Test
	public void testDivide() {
		final int result = calculator.divide(6, 2);
		assertEquals(3, result);
		verify(loggerMock, times(1)).debug(anyString());
	}

	@Test(expected = ArithmeticException.class)
	public void expectExceptionOnDivisionByZero() {
		calculator.divide(1, 0);
	}
}
