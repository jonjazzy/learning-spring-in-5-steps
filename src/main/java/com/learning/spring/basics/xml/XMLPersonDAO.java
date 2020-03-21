package com.learning.spring.basics.xml;

import org.springframework.beans.factory.annotation.Autowired;

public class XMLPersonDAO
{
    XMLJdbcConnection xmlJdbcConnection;

    public XMLJdbcConnection getXmlJdbcConnection() {
        return xmlJdbcConnection;
    }

    public void setXmlJdbcConnection(XMLJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
    }
}
