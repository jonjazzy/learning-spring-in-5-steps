package com.learning.spring.basics.learning.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		System.out.println("----------------------------------------------");
		int arrayLength = 1 + (int)(Math.random() * 15);
		System.out.println("Array length is: " + arrayLength);

		System.out.println("----------------------------------------------");
		RandomArray randomArray = new RandomArray(arrayLength);
		System.out.println("This is my unsorted array: ");
		System.out.println(Arrays.toString(randomArray.getIntegerArray()));

		System.out.println("----------------------------------------------");

		//Specify Sort ALgorithm
		System.out.print("Using QuickSort, ");
		BinarySearchImpl binarySearch =
				new BinarySearchImpl(new QuickSort());

		int numberToSearchFor = randomArray.getIntegerArray()[(int)(Math.random() * arrayLength)];
		int result = binarySearch.binarySearch(randomArray.getIntegerArray(), numberToSearchFor);

		System.out.println("The Index of (" + numberToSearchFor + ") is " + result);


		SpringApplication.run(Application.class, args);
	}
}
