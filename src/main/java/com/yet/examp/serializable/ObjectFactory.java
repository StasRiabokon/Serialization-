package com.yet.examp.serializable;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName Q_NAME = new QName(XMLConstants.NULL_NS_URI, "data");

    @XmlElementDecl(name = "dataObj")
    public JAXBElement<DataObject> createData(DataObject val) {
        return new JAXBElement<>(Q_NAME, DataObject.class, null, val);
    }

}
