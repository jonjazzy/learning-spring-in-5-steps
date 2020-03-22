package com.learning.spring.basics.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.lang.System.out;

//@Component
public class XMLPersonDAO
{
//    @Autowired
    XMLJdbcConnection xmlJdbcConnection;

    public XMLJdbcConnection getXmlJdbcConnection() {
        return xmlJdbcConnection;
    }

    public void setXmlJdbcConnection(XMLJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
    }

//    @PostConstruct
    public void postConstruct()
    {
        out.println("postConstruct -> XMLPersonDAO");
    }

//    @PreDestroy
    public void preDestroy()
    {
        out.println("preDestroy -> XMLPersonDAO");
    }
}
