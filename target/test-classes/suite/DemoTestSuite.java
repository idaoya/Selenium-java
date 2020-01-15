package suite;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import main.AddCustomerTest;
import main.AssertTest;
import main.DatabaseTest;
import main.ElementTest;
import main.JavaScriptTest;
import main.SearchTest;
import main.WaitsTest;

public class DemoTestSuite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(AddCustomerTest.class);
		suite.addTestSuite(AssertTest.class);
		suite.addTestSuite(DatabaseTest.class);
		suite.addTestSuite(ElementTest.class);
		suite.addTestSuite(JavaScriptTest.class);
		suite.addTestSuite(SearchTest.class);
		suite.addTestSuite(WaitsTest.class);
		return suite;
	}

	public static void main(String arg[]) {
		TestRunner.run(suite());
	}
}