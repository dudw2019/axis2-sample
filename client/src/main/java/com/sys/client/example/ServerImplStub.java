/**
 * ServerImplStub.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.sys.client.example;


import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.ds.jaxb.JAXBOMDataSource;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.util.jaxb.JAXBUtils;
import org.apache.axiom.util.jaxb.UnmarshallerAdapter;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.FaultMapKey;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Stub;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.description.WSDL2Constants;
import org.apache.axis2.util.CallbackReceiver;
import org.apache.axis2.util.Utils;
import org.apache.axis2.wsdl.WSDLConstants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * ServerImplStub java implementation
 */
public class ServerImplStub extends Stub {
    private static int counter = 0;
    
    private static final String targetEndpoint= "http://127.0.0.1:8080/services/server/";
    public static final String namespaceURI= "http://com.sys.service.example";
    
    /**
     * http://127.0.0.1:8080/services/server/
     */
    private static final JAXBContext wsContext;
    
    static {
        JAXBContext jc;
        jc = null;
        
        try {
            jc = JAXBContext.newInstance( SayHello.class ,
                    SayHelloResponse.class );
        } catch ( JAXBException ex ) {
            System.err.println( "Unable to create JAXBContext: " +
                    ex.getMessage() );
            ex.printStackTrace( System.err );
            Runtime.getRuntime().exit( - 1 );
        } finally {
            wsContext = jc;
        }
    }
    
    protected AxisOperation[] _operations;
    
    /**
     * hashmaps to keep the fault mapping
     */
    private HashMap faultExceptionNameMap = new HashMap();
    private HashMap faultExceptionClassNameMap = new HashMap();
    private HashMap faultMessageMap = new HashMap();
    private QName[] opNameArray = null;
    
    /**
     * Constructor that takes in a configContext
     */
    public ServerImplStub(
            ConfigurationContext configurationContext ,
            String targetEndpoint) throws AxisFault {
        this( configurationContext , targetEndpoint , false );
    }
    
    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public ServerImplStub(
            ConfigurationContext configurationContext ,
            String targetEndpoint , boolean useSeparateListener)
            throws AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();
        
        _serviceClient = new ServiceClient( configurationContext ,
                _service );
        
        _serviceClient.getOptions()
                .setTo( new EndpointReference(
                        targetEndpoint ) );
        _serviceClient.getOptions().setUseSeparateListener( useSeparateListener );
        
        //Set the soap version
        _serviceClient.getOptions()
                .setSoapVersionURI( SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI );
    }
    
    /**
     * Default Constructor
     */
    public ServerImplStub(ConfigurationContext configurationContext) throws AxisFault {
        this( configurationContext , targetEndpoint );
    }
    
    /**
     * Default Constructor
     */
    public ServerImplStub() throws AxisFault {
        this( targetEndpoint );
    }
    
    /**
     * Constructor taking the target endpoint
     */
    public ServerImplStub(String targetEndpoint)
            throws AxisFault {
        this( null , targetEndpoint );
    }
    
    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if ( counter > 99999 ) {
            counter = 0;
        }
        
        counter = counter + 1;
        
        return Long.toString( System.currentTimeMillis() ) +
                "_" + counter;
    }
    
    private void populateAxisService() throws AxisFault {
        //creating the Service with a unique name
        _service = new AxisService( "ServerImpl" +
                getUniqueSuffix() );
        addAnonymousOperations();
        
        //creating the operations
        AxisOperation __operation;
        
        _operations = new AxisOperation[1];
        
        __operation = new OutInAxisOperation();
        
        __operation.setName( new javax.xml.namespace.QName(
                namespaceURI , "sayHello" ) );
        _service.addOperation( __operation );
        
        _operations[0] = __operation;
    }
    
    /**
     * populates the faults
     */
    private void populateFaults() {
    }
    
    /**
     * Auto generated method signature
     *
     * @param sayHello0
     * @see
     */
    public Object sayHello(
            SayHello sayHello0)
            throws RemoteException {
        MessageContext _messageContext = new MessageContext();
        
        try {
            OperationClient _operationClient = _serviceClient.createClient( _operations[0].getName() );
            _operationClient.getOptions().setAction( "tns:sayHello" );
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault( true );
            
            addPropertyToOperationClient( _operationClient ,
                    WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR ,
                    "&" );
            
            // create SOAP envelope with that payload
            SOAPEnvelope env = toEnvelope( getFactory( _operationClient.getOptions().getSoapVersionURI() ) , sayHello0 ,
                    optimizeContent( new QName( namespaceURI , "sayHello" ) ) ,
                    new QName( namespaceURI , "sayHello" ) );
            
            // adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope( env );
            // set the message context with that soap envelope
            _messageContext.setEnvelope( env );
            
            // add the message contxt to the operation client
            _operationClient.addMessageContext( _messageContext );
            
            //execute the operation client
            _operationClient.execute( true );
            
            MessageContext _returnMessageContext = _operationClient.getMessageContext( WSDLConstants.MESSAGE_LABEL_IN_VALUE );
            SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            OMElement omElement = _returnEnv.getBody().getFirstElement();
            Object object = fromOM( omElement.getFirstElement() , SayHelloResponse.class );
            
            return object;
        } catch ( org.apache.axis2.AxisFault f ) {
            OMElement faultElt = f.getDetail();
            
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(
                        new FaultMapKey(
                                faultElt.getQName() , "sayHello" ) ) ) {
                    //make the fault by reflection
                    try {
                        String exceptionClassName = ( java.lang.String ) faultExceptionClassNameMap.get( new FaultMapKey(
                                faultElt.getQName() , "sayHello" ) );
                        Class exceptionClass = java.lang.Class.forName( exceptionClassName );
                        Constructor constructor = exceptionClass.getConstructor( java.lang.String.class );
                        Exception ex = ( java.lang.Exception ) constructor.newInstance( f.getMessage() );
                        
                        //message class
                        String messageClassName = ( java.lang.String ) faultMessageMap.get( new FaultMapKey(
                                faultElt.getQName() , "sayHello" ) );
                        Class messageClass = java.lang.Class.forName( messageClassName );
                        Object messageObject = fromOM( faultElt ,
                                messageClass );
                        Method m = exceptionClass.getMethod( "setFaultMessage" ,
                                new java.lang.Class[]{messageClass} );
                        m.invoke( ex , new java.lang.Object[]{messageObject} );
                        
                        throw new RemoteException( ex.getMessage() , ex );
                    } catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch ( ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch ( NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch ( InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch ( IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch ( InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender()
                        .cleanup( _messageContext );
            }
        }
    }
    
    private boolean optimizeContent(QName opName) {
        if ( opNameArray == null ) {
            return false;
        }

        for ( int i = 0 ; i < opNameArray.length ; i++ ) {
            if ( opName.equals( opNameArray[i] ) ) {
                return true;
            }
        }

        return false;
    }

    private OMElement toOM(
            SayHello param , boolean optimizeContent ,
            QName elementQName)
            throws AxisFault {
        OMFactory factory = OMAbstractFactory.getOMFactory();

        Object object = param;
        JAXBOMDataSource source = new JAXBOMDataSource( wsContext ,
                new JAXBElement( elementQName , object.getClass() ,
                        object ) );
        OMNamespace namespace = factory.createOMNamespace( elementQName.getNamespaceURI() ,
                null );

        return factory.createOMElement( source , elementQName.getLocalPart() ,
                namespace );
    }

    private SOAPEnvelope toEnvelope(
            SOAPFactory factory ,
            SayHello param , boolean optimizeContent ,
            QName elementQName)
            throws AxisFault {
        SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild( toOM( param , optimizeContent , elementQName ) );

        return envelope;
    }

    private OMElement toOM(
            SayHelloResponse param ,
            boolean optimizeContent , QName elementQName)
            throws AxisFault {
        OMFactory factory = OMAbstractFactory.getOMFactory();

        Object object = param;
        JAXBOMDataSource source = new JAXBOMDataSource( wsContext ,
                new JAXBElement( elementQName , object.getClass() ,
                        object ) );
        OMNamespace namespace = factory.createOMNamespace( elementQName.getNamespaceURI() ,
                null );

        return factory.createOMElement( source , elementQName.getLocalPart() ,
                namespace );
    }

    private SOAPEnvelope toEnvelope(
            SOAPFactory factory ,
            SayHelloResponse param ,
            boolean optimizeContent , QName elementQName)
            throws AxisFault {
        SOAPEnvelope envelope = factory.getDefaultEnvelope();
        envelope.getBody().addChild( toOM( param , optimizeContent , elementQName ) );

        return envelope;
    }
    
    /**
     * get the default envelope
     */
    private SOAPEnvelope toEnvelope(
            SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(OMElement param ,
                                    Class type) throws AxisFault {
        try {
            JAXBContext context = wsContext;
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UnmarshallerAdapter adapter = JAXBUtils.getUnmarshallerAdapter( param.getXMLStreamReaderWithoutCaching() );
            unmarshaller.setAttachmentUnmarshaller( adapter.getAttachmentUnmarshaller() );

            return unmarshaller.unmarshal( adapter.getReader() , type ).getValue();
        } catch ( JAXBException bex ) {
            throw AxisFault.makeFault( bex );
        }
    }
}
