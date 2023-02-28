
package com.epam.xmlparser.model.request;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "osInfoType", propOrder = {
    "value"
})
public class OsInfoType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "version")
    protected String version;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

}
