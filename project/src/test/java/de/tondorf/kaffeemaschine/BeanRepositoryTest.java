package de.tondorf.kaffeemaschine;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BeanRepositoryTest {

	private BeanRepository beanRepository;

	
	@Before 
	public void setup(){
		System.err.println("before");
		beanRepository = new BeanRepository();
	}
		
	@Test
	public void testBeanFillingAndGetting(){
		beanRepository.setBeanCount(100);
		List<Bean> beanList = beanRepository.getBeans(100);
		assertEquals(100, beanList.size());
	}
	
	@Test(expected=EmptyException.class)
	public void expectEmptyExceptionOnEmptyRepositoryGet(){
		beanRepository.setBeanCount(1);
		beanRepository.getBeans(2);
	}
	
	
}
