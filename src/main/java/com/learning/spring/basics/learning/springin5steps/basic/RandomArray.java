package com.learning.spring.basics.learning.springin5steps.basic;

import java.util.Random;

public class RandomArray
{
    private int[] integerArray;

    public RandomArray(int arraySize)
    {
        Random rd = new Random(); // creating Random object
        this.integerArray = new int[arraySize];

        for (int i = 0; i < this.integerArray.length; i++)
        {
            this.integerArray[i] = rd.nextInt(arraySize); // storing random integers in an array
        }
    }

    public int[] getIntegerArray() {
        return this.integerArray;
    }
}
