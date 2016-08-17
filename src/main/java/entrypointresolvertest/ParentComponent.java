package entrypointresolvertest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParentComponent 
{
	private final Logger logger = LogManager.getLogger(ParentComponent.class);
	
	protected void TestMethod3()
	{
		logger.info("TestMethod3 without parameters in parent component is executed");
	}
}
