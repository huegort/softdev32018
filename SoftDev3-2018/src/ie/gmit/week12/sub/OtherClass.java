package ie.gmit.week12.sub;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OtherClass {
	private static Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass());
	public OtherClass() {
		log.debug("in other class");
	}
}
