
package com.epam.xmlparser.model.request;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "screenInfoType", propOrder = {
    "value"
})
public class ScreenInfoType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "width")
    protected String width;
    @XmlAttribute(name = "height")
    protected String height;
    @XmlAttribute(name = "dpi")
    protected String dpi;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String value) {
        this.width = value;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String value) {
        this.height = value;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String value) {
        this.dpi = value;
    }

}
