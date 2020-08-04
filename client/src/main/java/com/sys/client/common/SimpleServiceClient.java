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

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class SimpleServiceClient {

    public static void main(String[] ars) throws AxisFault, XMLStreamException {
        // Client side keystore location, here we use same keystore
//        System.setProperty("javax.net.ssl.trustStore", "../httpsService/target/jetty-ssl.keystore");
//        System.setProperty("javax.net.ssl.trustStorePassword", "axis2key");
        String epr = "http://localhost:8080/services/server";

        Options options = new Options();
        options.setTo(new EndpointReference(epr));
        ServiceClient sender = new ServiceClient();
        sender.setOptions(options);
        OMElement ret = sender.sendReceive(creatMsg());
        ret.serialize(System.out);

    }

    public static OMElement creatMsg() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://example.service1",
                        "m0");
        OMElement method = fac.createOMElement("sayHello", omNs);
        OMElement value = fac.createOMElement("name", omNs);
        value.setText(" World ");
        method.addChild(value);
        method.build();
        return method;
    }

}
