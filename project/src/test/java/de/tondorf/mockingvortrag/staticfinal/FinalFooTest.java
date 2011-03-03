package de.tondorf.mockingvortrag.staticfinal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(MyCoolLibrary.class)
@RunWith(PowerMockRunner.class)
public class FinalFooTest {

	@Test
	public void testFinal() {
		final MyCoolLibrary lib = mock(MyCoolLibrary.class);

		final FinalFoo foo = new FinalFoo();
		foo.setLib(lib);
		foo.testFinal();

		verify(lib).doFinal();
	}

	@Test
	// coverage ;-)
	public void testFinalWithoutPowerMock() {
		final FinalFoo foo = new FinalFoo();
		foo.setLib(new MyCoolLibrary());
		foo.testFinal();
	}
}
