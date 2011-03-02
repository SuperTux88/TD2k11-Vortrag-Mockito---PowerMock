package de.tondorf.mockingvortrag.dispenser.impl;

import org.apache.log4j.Logger;

import de.tondorf.mockingvortrag.dispenser.Coke;
import de.tondorf.mockingvortrag.dispenser.CokeRepository;
import de.tondorf.mockingvortrag.dispenser.FantaRepository;

public class DrinksDispenser {
	private static final Logger LOG = Logger.getLogger(DrinksDispenser.class);

	private CokeRepository cokeRepo;
	private FantaRepository fantaRepo;

	public void setCokeRepository(final CokeRepository cokeRepo) {
		this.cokeRepo = cokeRepo;
	}

	public void setFantaRepository(final FantaRepository fantaRepo) {
		this.fantaRepo = fantaRepo;
	}

	public Coke getAfri() {
		try {
			return cokeRepo.get("afri");
		} catch (final EmptyException e) {
			LOG.error("EMPTY", e);
			return null;
		}
	}

	public Object getFanta() {
		try {
			return fantaRepo.get("fante");
		} catch (final EmptyException e) {
			LOG.error("EMPTY", e);
			return null;
		}
	}
}
