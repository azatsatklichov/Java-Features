package features.in.java7;

public class SafeRethrown {
	public void foo() 
	throws RedException, BlueException { 

	    try { 
	            ... 

	    } catch(final Throwable e) { 
	        LOGGER.info(e.getMessage(), e); 
	        throw e; 
	    } 
	 } 



}
