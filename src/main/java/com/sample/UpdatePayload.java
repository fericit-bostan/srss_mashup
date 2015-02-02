package com.sample;

import java.util.Map;

import org.mule.api.MuleContext;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;

import com.sample.utils.Constants;

public class UpdatePayload implements org.mule.api.lifecycle.Callable,
		org.mule.api.context.MuleContextAware {

	@SuppressWarnings("unused")
	private MuleContext context;

	@Override
	public void setMuleContext(MuleContext context) {
		this.context = context;

	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		MuleMessage message = eventContext.getMessage();
		Map results = (Map) message.getPayload();

		String tmp = (String) message.getSessionProperty(Constants.SESSION_REQUESTED_ADDRESS_KEY);
		results.put(Constants.SESSION_REQUESTED_ADDRESS_KEY, tmp);
//		
//		tmp = (String) message.getSessionProperty(Constants.SESSION_LATITUDE_KEY);
//		results.put(Constants.SESSION_LATITUDE_KEY, tmp);
//		
//		tmp = (String) message.getSessionProperty(Constants.SESSION_LONGITUDE_KEY);
//		results.put(Constants.SESSION_LONGITUDE_KEY, tmp);
//		
		return message.getPayload();
	}
}
