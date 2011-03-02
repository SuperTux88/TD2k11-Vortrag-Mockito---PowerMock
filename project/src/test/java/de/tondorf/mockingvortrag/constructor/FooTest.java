package de.tondorf.mockingvortrag.constructor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class FooTest {
	@Test
	public void testSum() {
		final Foo comp = Whitebox.newInstance(Foo.class);
		assertEquals(5, comp.sum(2, 3));
	}

	@Test
	// Fuer coverage
	public void testConstructor() {
		new Foo();
	}
}
