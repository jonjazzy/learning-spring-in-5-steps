package com.learning.spring.basics.learning.springin5steps.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

/*
    *Here is a subtle point you need to be aware of with "prototype" scoped beans.

For "prototype" scoped beans, Spring does not call the @PreDestroy method.
Here is the answer from the Spring reference manual. Section 1.5.2

https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes-prototype

In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean:
* the container instantiates, configures, and otherwise assembles a prototype object,
* and hands it to the client, with no further record of that prototype instance.

Thus, although initialization lifecycle callback methods are called on all objects regardless of scope,
* in the case of prototypes, configured destruction lifecycle callbacks are not called.
* The client code must clean up prototype-scoped objects and release expensive resources
* that the prototype bean(s) are holding.

To get the Spring container to release resources held by prototype-scoped beans,
* try using a custom bean post-processor, which holds a reference to beans that need to be cleaned up.

NOTE: This also applies to XML configuration.
    *
    */

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)     //Each bean returned is different
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)   //Same bean is returned always
public class BinarySearchImpl
{
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
//    @Qualifier("quick")
//    @Qualifier("bubble")
    private SortAlgorithm sortAlgorithm;

    //Constructor Injection
//    public BinarySearchImpl(SortAlgorithm sortAlgorithm)
//    {
//        this.sortAlgorithm = sortAlgorithm;
//    }

//    //Setter Injection
//    public void setSortingMethod(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }

    public int binarySearch(int[] numbers, int numberToSearchFor)
    {
        //  (1) Sort the Array
//        Arrays.sort(numbers);
//        sortAlgorithm = new BubbleSort();
        sortAlgorithm.sort(numbers);
            System.out.println("This is my sorted Array: ");
            System.out.println(Arrays.toString(numbers));
            System.out.println("----------------------------------------------");

        //  (2) Search the Array
            System.out.println("The number to search for is: " + numberToSearchFor);
            System.out.println("----------------------------------------------");
        int index = -1;
        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] == numberToSearchFor)
            {
                index = i;
            }
        }

        //  (3) Return the result [index]
        return index;
    }

    @PostConstruct
    public void postConstruct()
    {
        LOGGER.info("postConstruct --> BinarySearchImpl");   //This will initialize as soon as the dependency is available
        System.out.println("postConstruct --> BinarySearchImpl");
    }

    @PreDestroy
    public void preDestroy()
    {
        LOGGER.info("preDestroy  --> BinarySearchImpl");
        System.out.println("preDestroy --> BinarySearchImpl");
    }
}
