package com.sys.service.handler;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.common.OMNamespaceImpl;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.handlers.AbstractHandler;

import java.util.Iterator;

public class OutMessageHandler extends AbstractHandler {
    @Override
    public InvocationResponse invoke(MessageContext msgContext) throws AxisFault {
        SOAPEnvelope envelope = msgContext.getEnvelope();
        SOAPBody body = envelope.getBody();
        Iterator allDeclaredNamespaces = body.getAllDeclaredNamespaces();
        while ( allDeclaredNamespaces.hasNext() ) {
            Object next = allDeclaredNamespaces.next();
            
        }
        return InvocationResponse.CONTINUE;
    }
}
