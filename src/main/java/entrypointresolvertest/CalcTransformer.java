package entrypointresolvertest;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalcTransformer extends AbstractMessageTransformer {

	private Logger logger = LogManager.getLogger(CalcTransformer.class);
	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		try 
		{
			String messageStr = message.getPayloadAsString();
			JSONObject jsonObj = JSON.parseObject(messageStr);
			
			Object[] paramArray = new Object[3];
			String param1 = jsonObj.getString("operand1");
			String param2 = jsonObj.getString("operand2");
			String param3 = jsonObj.getString("operator");
			paramArray[0] = Integer.parseInt(param1);
			paramArray[1] = Integer.parseInt(param2);
			paramArray[2] = param3;	
			return paramArray;
			
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}
}
