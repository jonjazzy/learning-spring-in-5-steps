package com.learning.spring.basics.xml;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class XMLJdbcConnection
{
    public XMLJdbcConnection()
    {
        System.out.println("XMLJdbcConnection Connected!");
    }

//    @PostConstruct
    public void postConstruct()
    {
        System.out.println("postConstruct -> XMLJdbcConnection");
    }

//    @PreDestroy
    public void preDestroy()
    {
        System.out.println("preDestroy -> XMLJdbcConnection");
    }
}
