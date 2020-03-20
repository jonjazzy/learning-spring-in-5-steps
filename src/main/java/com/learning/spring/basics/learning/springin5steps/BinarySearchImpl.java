package com.learning.spring.basics.learning.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)     //Each bean returned is different
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)   //Same bean is returned always
public class BinarySearchImpl
{
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
}
