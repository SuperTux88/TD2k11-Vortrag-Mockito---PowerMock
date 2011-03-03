package de.tondorf.mockingvortrag.staticfinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(DrEvil.class)
@RunWith(PowerMockRunner.class)
public class StaticFooTest {

	@Test
	public void testStatic() {
		mockStatic(DrEvil.class);
		when(DrEvil.getEvil(anyInt())).thenReturn(1);
		final StaticFoo foo = new StaticFoo();
		assertEquals(1, foo.testStatic());

		// static verification
		verifyStatic();
		DrEvil.getEvil(anyInt());
	}

	@Test
	// coverage ;-)
	public void testStaticWithoutPowerMock() {
		new StaticFoo().testStatic();
	}
}
