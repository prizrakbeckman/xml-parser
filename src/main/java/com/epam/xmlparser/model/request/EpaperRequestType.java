
package com.epam.xmlparser.model.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "epaperRequestType", propOrder = {
    "deviceInfo",
    "getPages"
})
public class EpaperRequestType {

    @XmlElement(required = true)
    protected DeviceInfoType deviceInfo;
    @XmlElement(required = true)
    protected GetPagesType getPages;

    public DeviceInfoType getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoType value) {
        this.deviceInfo = value;
    }

    public GetPagesType getGetPages() {
        return getPages;
    }

    public void setGetPages(GetPagesType value) {
        this.getPages = value;
    }

}
