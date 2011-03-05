package de.tondorf.kaffeemaschine;

import java.util.ArrayList;
import java.util.List;

public class BeanRepository {
	private int beanCount = 0;
	
	public void setBeanCount(int beanCount){
		this.beanCount=beanCount;
	}
	
	/**
	 * 
	 * @param count 
	 * @return a list of the beans you can use for your coffee
	 * @throws new EmptyException when not enough beans are available
	 */
	public List<Bean> getBeans(int count){
		if(count > this.beanCount) throw new EmptyException();
		beanCount -= count;
		
		List<Bean> beanList = new ArrayList<Bean>();
		for(int i = 0; i < count; i++){
			beanList.add(new Bean());
		}
		return beanList;
	}
		
}
