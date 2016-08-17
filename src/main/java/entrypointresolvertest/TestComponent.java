package entrypointresolvertest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestComponent
{
	private final Logger logger = LogManager.getLogger(TestComponent.class);
	
	public void MethodEntryPointMethod1(String message)
	{
		logger.info("MethodEntryPointMethod1's message is:" + message);
	}
	
	public void MethodEntryPointMethod2(String message)
	{
		logger.info("MethodEntryPointMethod2's message is:" + message);
	}
	
	public void NoArgumentEntryPointMethod1()
	{
		logger.info("NoArgumentEntryPointMethod is executed");
	}
	
	public void NoArgumentEntryPointMethod2()
	{
		logger.info("NoArgumentEntryPointMethod2 is executed");
	}
	
	public void PropertyEntryPointMethod(String message)
	{
		logger.info("PropertyEntryPointMethod's message is:" + message);
	}
	
	public void ArrayEntryPointResolverMethod1(String[] args)
	{
		logger.info("ArrayEntryPointResolverMethod1 is executed!");
		logger.info("This first argument is:" + args[0]);
		logger.info("This second argument is:" + args[1]);
	}
	
	public void ArrayEntryPointResolverMethod2(Object[] args)
	{
		logger.info("ArrayEntryPointResolverMethod2 is executed!");
		logger.info("This first argument is:" + args[0].toString());
		logger.info("This second argument is:" + args[1].toString());
	}
	
}
