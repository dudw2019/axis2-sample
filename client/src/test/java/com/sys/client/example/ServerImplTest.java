/**
 * ServerImplTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.sys.client.example;


import javax.xml.bind.JAXBElement;

/*
 *  ServerImplTest Junit test case
 */
public class ServerImplTest extends junit.framework.TestCase {
    /**
     * Auto generated test method
     */
    public void testSayHello() throws java.lang.Exception {
        ServerImplStub stub = new ServerImplStub(); //the default implementation should point to the right endpoint
        SayHello param = ( SayHello ) getTestObject( SayHello.class );
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> sayHelloName = objectFactory.createSayHelloName( "123" );
        param.setName( sayHelloName );
        SayHelloResponse response = (SayHelloResponse)stub.sayHello( param );
        assertNotNull( response.getReturn().getValue() );
        assertEquals( response.getReturn().getValue(), "Hello 123" );
    }
    
    //Create an object and provide it as the test object
    public Object getTestObject(Class type) throws Exception {
        Object instance = type.newInstance();
        return instance;
    }

}
