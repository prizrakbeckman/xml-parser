
package com.epam.xmlparser.model.request;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deviceInfoType", propOrder = {
    "screenInfo",
    "osInfo",
    "appInfo"
})
public class DeviceInfoType {

    @XmlElement(required = true)
    protected ScreenInfoType screenInfo;
    @XmlElement(required = true)
    protected OsInfoType osInfo;
    @XmlElement(required = true)
    protected AppInfoType appInfo;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "id")
    protected String id;

    public ScreenInfoType getScreenInfo() {
        return screenInfo;
    }

    public void setScreenInfo(ScreenInfoType value) {
        this.screenInfo = value;
    }

    public OsInfoType getOsInfo() {
        return osInfo;
    }

    public void setOsInfo(OsInfoType value) {
        this.osInfo = value;
    }

    public AppInfoType getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfoType value) {
        this.appInfo = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
