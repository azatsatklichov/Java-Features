package features.in.java7;

public class ExceptionBoilerplate {
	public static void main(String[] args) {
		// too much boilerplate!!! 
	} catch(RedException e) { 
	   LOGGER.info(e.getMessage(), e); 
	   throw e; 
	} catch(BlueException e) { 
	   LOGGER.info(e.getMessage(), e); 
	   throw e; 
	} 

	// Catch common superclass??? 
	} catch(Exception e) { 
	   LOGGER.info(e.getMessage(), e); 
	   throw e; 
	} 
	}

}
