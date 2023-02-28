
package com.epam.xmlparser.model.request;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPagesType", propOrder = {
    "value"
})
public class GetPagesType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "editionDefId")
    protected String editionDefId;
    @XmlAttribute(name = "publicationDate")
    protected String publicationDate;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEditionDefId() {
        return editionDefId;
    }

    public void setEditionDefId(String value) {
        this.editionDefId = value;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String value) {
        this.publicationDate = value;
    }

}
