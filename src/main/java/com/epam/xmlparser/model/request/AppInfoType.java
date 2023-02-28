
package com.epam.xmlparser.model.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appInfoType", propOrder = {
    "newspaperName",
    "version"
})
public class AppInfoType {

    @XmlElement(required = true)
    protected String newspaperName;
    @XmlElement(required = true)
    protected String version;

    public String getNewspaperName() {
        return newspaperName;
    }

    public void setNewspaperName(String value) {
        this.newspaperName = value;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

}
