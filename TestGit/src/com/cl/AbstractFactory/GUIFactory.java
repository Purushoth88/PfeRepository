package com.cl.AbstractFactory;

public abstract class GUIFactory {
	
	 public static GUIFactory getFactory()
	    {
	         int sys = readFromConfigFile("OS_TYPE");
	 
	         if (sys == 0)
	             return(new WinFactory());
	 
	         return(new OSXFactory());
	    }
	    
	
		private static int readFromConfigFile(String string) {
		// TODO Auto-generated method stub
		return 125;
	}


		public abstract Button createButton();

}
