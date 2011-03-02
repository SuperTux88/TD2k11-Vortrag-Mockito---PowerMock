package de.tondorf.mockingvortrag.constructor;

public class Foo {
	  public Foo(){
		    if(!MyFrameworkMegaUtil.isFrameworkProperlyInitialized()){
		      MyFrameworkMegaUtil.initializeFramework();	
		    }
		  }

		  public int sum(int x, int y){
		    return x+y;
		  }

}
