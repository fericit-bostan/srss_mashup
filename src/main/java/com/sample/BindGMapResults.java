package com.sample;

import java.util.Map;

import org.mule.api.MuleContext;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;

import com.sample.utils.Constants;

public class BindGMapResults implements org.mule.api.lifecycle.Callable,
		org.mule.api.context.MuleContextAware {

	@SuppressWarnings("unused")
	private MuleContext context;

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();

		Map payload = (Map) message.getPayload();
		Map geometry = (Map) payload.get(Constants.PAYLOAD_GEOMETRY_KEY);
		Map<String, String> location = (Map<String, String>) geometry
				.get(Constants.PAYLOAD_LOCATION_KEY);

		String longitude = (String) location
				.get(Constants.PAYLOAD_LONGITUDE_KEY);
		String latitude = (String) location.get(Constants.PAYLOAD_LATITUDE_KEY);

		message.setSessionProperty(Constants.SESSION_LONGITUDE_KEY, longitude);
		message.setSessionProperty(Constants.SESSION_LATITUDE_KEY, latitude);
		message.setSessionProperty(Constants.SESSION_TIMEZON_LOCATION_KEY,
				latitude + "," + longitude);

		String requestedAddress = (String) payload
				.get(Constants.PAYLOAD_FORMATTED_ADDRESS_KEY);
		message.setSessionProperty(Constants.SESSION_REQUESTED_ADDRESS_KEY,requestedAddress);

		message.setPayload(null);
		return message.getPayload();
	}

	@Override
	public void setMuleContext(MuleContext context) {
		this.context = context;

	}
}
