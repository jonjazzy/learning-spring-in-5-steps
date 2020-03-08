package com.learning.spring.basics.learning.springin5steps;

import java.util.Arrays;

public class BinarySearchImpl
{
    private SortAlgorithm sortingMethod;

    public BinarySearchImpl(SortAlgorithm sortingMethod)
    {
        this.sortingMethod = sortingMethod;
    }

    public int binarySearch(int[] numbers, int numberToSearchFor)
    {
        //  (1) Sort the Array
//        Arrays.sort(numbers);
        sortingMethod = new BubbleSort();
        sortingMethod.sort(numbers);
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
