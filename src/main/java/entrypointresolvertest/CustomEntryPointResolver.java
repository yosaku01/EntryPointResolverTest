package entrypointresolvertest;

import java.lang.reflect.Method;

import org.mule.api.MuleEventContext;
import org.mule.api.model.InvocationResult;
import org.mule.model.resolvers.AbstractEntryPointResolver;
import org.mule.util.ClassUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomEntryPointResolver extends AbstractEntryPointResolver {

	private Logger logger = LogManager.getLogger(CustomEntryPointResolver.class);
	
	@Override
	public InvocationResult invoke(Object component, MuleEventContext context) throws Exception {
		
		try
		{
			Object[] payload = getPayloadFromMessage(context);
			
			if(payload != null && payload.length == 3)
			{
					int number1 = Integer.parseInt(payload[0].toString());
					int number2 = Integer.parseInt(payload[1].toString());				
					String operandName = payload[2].toString();
					Class<?>[] classTypes = ClassUtils.getClassTypes(payload);
					Class<?>[] paramTypes = new Class<?>[2];
					for(int i=0; i<2;i++)
					{
						paramTypes[0] = classTypes[0];
						paramTypes[1] = classTypes[1];
					}
					Method method = getMethodByName(component, operandName, context);
					if (method == null)
			        {
			            method = ClassUtils.getMethod(component.getClass(), operandName, paramTypes, true);
			        }
			        if (method != null)
		            {
		                addMethodByName(component, method, context);	
		                
	                	Object[] arguments = new Object[2];
	                	arguments[0] = number1;
	                	arguments[1] = number2;
	                	InvocationResult result = invokeMethod(component, method, arguments);
	                	return result;
		            }
			        else
			        {
			        	InvocationResult result = new InvocationResult(this, InvocationResult.State.FAILED);
				        result.setErrorNoMatchingMethods(component, classTypes);
				        return result;
			        }
			}
			else
			{
				Class<?>[] classTypes = ClassUtils.getClassTypes(payload);
				InvocationResult result = new InvocationResult(this, InvocationResult.State.FAILED);
		        result.setErrorNoMatchingMethods(component, classTypes);
		        return result;
			}
		}
		catch(Exception ex)
		{
			logger.error(ExceptionUtils.getFullStackTrace(ex));
		}		
		return null;
	}

}
