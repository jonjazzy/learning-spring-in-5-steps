package com.learning.spring.basics.learning.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BinarySearchImpl
{
    @Autowired
    private SortAlgorithm bubbleSort;

    //Constructor Injection
//    public BinarySearchImpl(SortAlgorithm bubbleSort)
//    {
//        this.bubbleSort = bubbleSort;
//    }

//    //Setter Injection
//    public void setSortingMethod(SortAlgorithm bubbleSort) {
//        this.bubbleSort = bubbleSort;
//    }

    public int binarySearch(int[] numbers, int numberToSearchFor)
    {
        //  (1) Sort the Array
//        Arrays.sort(numbers);
//        bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
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
