package entrypointresolvertest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.hazelcast.com.eclipsesource.json.JsonObject;

public class TestTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		String messageStr = null;
		try {
			messageStr = message.getPayloadAsString();
			JsonObject jsonObj = JsonObject.readFrom(messageStr);
			List<Integer> operandList = new ArrayList<Integer>();
			operandList.add(jsonObj.getInt("operand1", 0));
			operandList.add(jsonObj.getInt("operand2", 0));
			
			Integer[] operandArray = 
					operandList.toArray(new Integer[operandList.size()]);
			return operandArray;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
		
//		List<String> messageList = new ArrayList<String>();
//		
//		messageList.add(jsonObj.get("id").asString());
//		messageList.add(jsonObj.get("name").asString());		
//		
//		String[] messageArray = 
//				messageList.toArray(new String[messageList.size()]);
		
	}

	
}
