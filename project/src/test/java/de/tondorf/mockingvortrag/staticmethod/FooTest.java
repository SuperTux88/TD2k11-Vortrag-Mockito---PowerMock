package de.tondorf.mockingvortrag.staticmethod;

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
public class FooTest {

	@Test
	public void testIt() {
		mockStatic(DrEvil.class);
		when(DrEvil.getEvil(anyInt())).thenReturn(1);
		final Foo foo = new Foo();
		assertEquals(1, foo.testMe());

		// static verification
		verifyStatic();
		DrEvil.getEvil(anyInt());
	}

	@Test
	// coverage ;-)
	public void testWithoutPowerMock() {
		new Foo().testMe();
	}
}
