package unitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConsumerTestSuite.class, FactoryTestSuite.class,
		OrderTestSuite.class, ProducerTestSuite.class, ProductTestSuite.class })
public class AllTests {

}
