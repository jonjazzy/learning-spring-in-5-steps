package com.learning.spring.basics.cdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCdiBusiness
{
    @Inject
    SomeCdiDAO someCdiDAO;

    public SomeCdiDAO getSomeCdiDAO()
    {
        return someCdiDAO;
    }

    public void setSomeCdiDAO(SomeCdiDAO someCdiDAO)
    {
        this.someCdiDAO = someCdiDAO;
    }
}
