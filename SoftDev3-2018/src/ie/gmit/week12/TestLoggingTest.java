package ie.gmit.week12;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLoggingTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// st table AND SAMPLE DATA
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		// CLEAN TABLES
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTestLogging() {
		assertTrue("the univers is safe",(1==1));
	}

	@Test
	void testAMethod() {
		TestLogging tf = new TestLogging();
		
		String m = "hi";
		assertTrue("return should be the same", m.equals(tf.aMethod(m)));
	}

}
