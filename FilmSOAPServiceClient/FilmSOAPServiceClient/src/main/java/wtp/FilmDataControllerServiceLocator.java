/**
 * FilmDataControllerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wtp;

public class FilmDataControllerServiceLocator extends org.apache.axis.client.Service implements wtp.FilmDataControllerService {

    public FilmDataControllerServiceLocator() {
    }


    public FilmDataControllerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FilmDataControllerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FilmDataController
    private java.lang.String FilmDataController_address = "http://localhost:8080/FilmSOAPService/services/FilmDataController";

    public java.lang.String getFilmDataControllerAddress() {
        return FilmDataController_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FilmDataControllerWSDDServiceName = "FilmDataController";

    public java.lang.String getFilmDataControllerWSDDServiceName() {
        return FilmDataControllerWSDDServiceName;
    }

    public void setFilmDataControllerWSDDServiceName(java.lang.String name) {
        FilmDataControllerWSDDServiceName = name;
    }

    public wtp.FilmDataController getFilmDataController() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FilmDataController_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFilmDataController(endpoint);
    }

    public wtp.FilmDataController getFilmDataController(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wtp.FilmDataControllerSoapBindingStub _stub = new wtp.FilmDataControllerSoapBindingStub(portAddress, this);
            _stub.setPortName(getFilmDataControllerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFilmDataControllerEndpointAddress(java.lang.String address) {
        FilmDataController_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wtp.FilmDataController.class.isAssignableFrom(serviceEndpointInterface)) {
                wtp.FilmDataControllerSoapBindingStub _stub = new wtp.FilmDataControllerSoapBindingStub(new java.net.URL(FilmDataController_address), this);
                _stub.setPortName(getFilmDataControllerWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FilmDataController".equals(inputPortName)) {
            return getFilmDataController();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wtp", "FilmDataControllerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wtp", "FilmDataController"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FilmDataController".equals(portName)) {
            setFilmDataControllerEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
