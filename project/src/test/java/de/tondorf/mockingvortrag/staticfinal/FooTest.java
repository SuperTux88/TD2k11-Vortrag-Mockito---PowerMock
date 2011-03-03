package de.tondorf.mockingvortrag.staticfinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest({ DrEvil.class, MyCoolLibrary.class })
@RunWith(PowerMockRunner.class)
public class FooTest {

	// static
	@Test
	public void testStatic() {
		mockStatic(DrEvil.class);
		when(DrEvil.getEvil(anyInt())).thenReturn(1);
		final Foo foo = new Foo();
		assertEquals(1, foo.testStatic());

		// static verification
		verifyStatic();
		DrEvil.getEvil(anyInt());
	}

	@Test
	// coverage ;-)
	public void testStaticWithoutPowerMock() {
		new Foo().testStatic();
	}

	// final
	@Test
	public void testFinal() {
		final MyCoolLibrary lib = mock(MyCoolLibrary.class);

		final Foo foo = new Foo();
		foo.setLib(lib);
		foo.testFinal();

		verify(lib).doFinal();
	}

	@Test
	// coverage ;-)
	public void testFinalWithoutPowerMock() {
		final Foo foo = new Foo();
		foo.setLib(new MyCoolLibrary());
		foo.testFinal();
	}
}
