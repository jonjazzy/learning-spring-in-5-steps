package com.learning.spring.basics.learning.springin5steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubbleSort implements SortAlgorithm
{
    public BubbleSort()
    {

    }

    public void sort(int[] integerArray)
    {
        System.out.println("Using BubbleSort");
        int n = integerArray.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (integerArray[j] > integerArray[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = integerArray[j];
                    integerArray[j] = integerArray[j + 1];
                    integerArray[j + 1] = temp;
                }
            }
        }
    }
}
