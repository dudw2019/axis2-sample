package com.sys.service.example;

import com.sys.service.process.ServerProcess;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(
        targetNamespace = ServerConst.namespaceURI,
        endpointInterface = ServerConst.endpoint,
        serviceName = ServerConst.serviceName
)
@BindingType(value= SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public class ServerImpl implements Server {
    
    ServerProcess server = new ServerProcess();
    
    @Override
    public SayHelloResponse sayHello(String name) {
        String s = server.sayHello( name );
        ObjectFactory objectFactory = new ObjectFactory();
        SayHelloResponse sayHelloResponse = objectFactory.createSayHelloResponse();
        sayHelloResponse.setReturn( objectFactory.createSayHelloResponseReturn( s ) );
        return sayHelloResponse;
    }
}
