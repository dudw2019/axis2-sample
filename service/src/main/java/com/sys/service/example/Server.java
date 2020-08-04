package com.sys.service.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(
        targetNamespace = ServerConst.namespaceURI
)
@BindingType(value= SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public interface Server {
    @WebMethod
    SayHelloResponse sayHello(@WebParam(name = "name") String name);
}
