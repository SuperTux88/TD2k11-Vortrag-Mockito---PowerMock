package de.tondorf.mockingvortrag.dispenser.impl;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import de.tondorf.mockingvortrag.dispenser.CokeRepository;
import de.tondorf.mockingvortrag.dispenser.Fanta;
import de.tondorf.mockingvortrag.dispenser.FantaRepository;

public class DrinkDispenserTest {

	@Test
	public void testDispenser() {
		final CokeRepository cokeRepo = mock(CokeRepository.class);
		final FantaRepository fantaRepo = mock(FantaRepository.class);

		when(cokeRepo.get("afri")).thenReturn(new AfriCola());
		when(fantaRepo.get(anyString())).thenThrow(new EmptyException());

		final DrinksDispenser drinkDispenser = new DrinksDispenser();
		drinkDispenser.setCokeRepository(cokeRepo);
		drinkDispenser.setFantaRepository(fantaRepo);

		assertTrue(drinkDispenser.getAfri() instanceof AfriCola);
		assertNull(drinkDispenser.getFanta());

		verify(cokeRepo, times(1)).get("afri");
		verify(fantaRepo, times(1)).get(anyString());

		verifyNoMoreInteractions(cokeRepo);
		verifyNoMoreInteractions(fantaRepo);
	}
	
	@Test
	public void testNoAfri() {
		final CokeRepository cokeRepo = mock(CokeRepository.class);
		final AfriCola afri = mock(AfriCola.class);
		
		when(cokeRepo.get("afri")).thenThrow(new EmptyException());

		final DrinksDispenser drinkDispenser = new DrinksDispenser();
		drinkDispenser.setCokeRepository(cokeRepo);

		assertNull(drinkDispenser.getAfri());

		verify(cokeRepo, times(1)).get("afri");

		verifyNoMoreInteractions(cokeRepo);
	}
	
	@Test
	public void testFanta() {
		final FantaRepository fantaRepo = mock(FantaRepository.class);
		final Fanta fanta = mock(Fanta.class);
		
		when(fantaRepo.get("fanta")).thenReturn(fanta);

		final DrinksDispenser drinkDispenser = new DrinksDispenser();
		drinkDispenser.setFantaRepository(fantaRepo);

		assertSame(fanta, drinkDispenser.getFanta());

		verify(fantaRepo, times(1)).get("fanta");

		verifyNoMoreInteractions(fantaRepo);
	}
}
