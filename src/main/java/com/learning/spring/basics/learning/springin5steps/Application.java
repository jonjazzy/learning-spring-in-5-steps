package com.learning.spring.basics.learning.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class Application
{
	/*
	 *	For spring to do its work, it needs to know 3 things:-
	 *
	 * 		1) What are the beans in your program?
	 * 		(e.g. instance of QuickSort() and BubbleSort().
	 * 		This is done using the @Component command)
	 *
	 * 		2) What are the dependencies of beans?
 * 			(e.g. SortAlgorithm is a dependency of BinarySearchImpl).
 * 			This was done by adding @Autowired on SortingAlgorithm, under BinarySearchImpl.
 * 			This is because SortingAlgorithm is a dependency of BinarySearchImpl
 *
	 * 		3) Where to search for beans? --> No need
	 * 		These are all in the package com.learning.spring.basics.learning.springin5steps
	 * 		We want spring boot to do a component scan of com.learning.spring.basics.learning.springin5steps
	 * 		this is done by @SpringBootApplication, as it tells spring to search springin5steps
	 * 		and its sub-packages
	 *
	 */
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

		/*
		//Specify Sort ALgorithm
		System.out.print("Using QuickSort, ");
		BinarySearchImpl binarySearch =
				new BinarySearchImpl(new QuickSort());	//QuickSort is a bean
		*/

		int numberToSearchFor = randomArray.getIntegerArray()[(int)(Math.random() * arrayLength)];

		//Application Context manages all our Beans!
		ApplicationContext applicationContext =
				SpringApplication.run(Application.class, args);

		//get the BinarySearchImpl bean, from the applicationContext (managed by Spring)
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);

		//Bean Scopes
		System.out.println("----------------------------------------------");
		System.out.println("Checking my Bean Scopes");
		System.out.println("binarySearch scope info is:- " + binarySearch);
		System.out.println("binarySearch2 scope info is:- " + binarySearch2);
		System.out.println("----------------------------------------------");

		int result = binarySearch.binarySearch(randomArray.getIntegerArray(), numberToSearchFor);

		System.out.println("The Index of (" + numberToSearchFor + ") is " + result);
	}
}
