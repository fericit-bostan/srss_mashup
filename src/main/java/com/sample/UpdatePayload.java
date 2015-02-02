/*
 *  UpdatePayload.java
 *  Created by Christopher Mathrusse on 01/26/15.
 */

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

	/* (non-Javadoc)
	 * @see org.mule.api.context.MuleContextAware#setMuleContext(org.mule.api.MuleContext)
	 */
	@Override
	public void setMuleContext(MuleContext context) {
		this.context = context;

	}

	/* (non-Javadoc)
	 * @see org.mule.api.lifecycle.Callable#onCall(org.mule.api.MuleEventContext)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		MuleMessage message = eventContext.getMessage();
		Map results = (Map) message.getPayload();

		String tmp = (String) message.getSessionProperty(Constants.SESSION_REQUESTED_ADDRESS_KEY);
		results.put(Constants.SESSION_REQUESTED_ADDRESS_KEY, tmp);

		return message.getPayload();
	}
}
