package com.cinema;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(HomeDAOImplTest.class);
		//$JUnit-END$
		return suite;
	}

}
