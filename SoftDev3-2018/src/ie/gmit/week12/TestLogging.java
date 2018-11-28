package ie.gmit.week12;


import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogging {
	private static Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass());
	public TestLogging() {
		log.debug("hi mom");
		log.info("this is an info");
		
	}
	public void aMethod(String msg) {
		log.debug(msg);
		
	}

}
