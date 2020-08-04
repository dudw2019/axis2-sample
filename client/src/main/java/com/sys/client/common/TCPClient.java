/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.sys.client.common;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This is a Client progam that accesses 'MyService' web service in Axis2 samples
 */
public class TCPClient {
    
    
    public static void main(String[] args) throws SOAPException, MalformedURLException {
        String endpointUrl = "http://localhost:8080/services/server";
        
        QName serviceName = new QName( "http://example" ,
                "Server" );
        QName portName = new QName( "http://example" ,
                "ServerImplHttpSoap11Endpoint" );
        
        /** Create a service and add at least one port to it. **/
        Service service = Service.create( serviceName );
        service.addPort( portName , SOAPBinding.SOAP11HTTP_BINDING , endpointUrl );
        
        /** Create a Dispatch instance from a service.**/
        Dispatch<SOAPMessage> dispatch = service.createDispatch( portName ,
                SOAPMessage.class , Service.Mode.MESSAGE );
        
        /** Create SOAPMessage request. **/
        // compose a request message
        MessageFactory mf = MessageFactory.newInstance( SOAPConstants.SOAP_1_1_PROTOCOL );
        
        // Create a message.  This example works with the SOAPPART.
        SOAPMessage request = mf.createMessage();
        SOAPPart part = request.getSOAPPart();
        
        // Obtain the SOAPEnvelope and header and body elements.
        SOAPEnvelope env = part.getEnvelope();
        SOAPHeader header = env.getHeader();
        SOAPBody body = env.getBody();
        
        // Construct the message payload.
        SOAPElement operation = body.addChildElement( "invoke" , "ns1" ,
                "http://example" );
        SOAPElement value = operation.addChildElement( "arg0" );
        value.addTextNode( "ping" );
        request.saveChanges();
        
        /** Invoke the service endpoint. **/
        SOAPMessage response = dispatch.invoke( request );
        System.out.println( response );
    }
}
