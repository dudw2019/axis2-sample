package com.sys.transport;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.http.CommonsHTTPTransportSender;

/**
 * @author du.dawei
 * @title CustomTransportSender
 * @projectName axis2
 * @date 7/31/2020 4:15 PM
 * @description : TODO
 **/
public class CustomTransportSender extends CommonsHTTPTransportSender {
    @Override
    public InvocationResponse invoke(MessageContext msgContext) throws AxisFault {
        
        return super.invoke( msgContext );
    }
}
