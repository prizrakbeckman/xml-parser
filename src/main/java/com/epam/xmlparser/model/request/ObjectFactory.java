
package com.epam.xmlparser.model.request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _EpaperRequest_QNAME = new QName("", "epaperRequest");

    public ObjectFactory() {
    }

    public EpaperRequestType createEpaperRequestType() {
        return new EpaperRequestType();
    }

    public ScreenInfoType createScreenInfoType() {
        return new ScreenInfoType();
    }

    public OsInfoType createOsInfoType() {
        return new OsInfoType();
    }

    public AppInfoType createAppInfoType() {
        return new AppInfoType();
    }

    public DeviceInfoType createDeviceInfoType() {
        return new DeviceInfoType();
    }

    public GetPagesType createGetPagesType() {
        return new GetPagesType();
    }
    @XmlElementDecl(namespace = "", name = "epaperRequest")
    public JAXBElement<EpaperRequestType> createEpaperRequest(EpaperRequestType value) {
        return new JAXBElement<EpaperRequestType>(_EpaperRequest_QNAME, EpaperRequestType.class, null, value);
    }

}
