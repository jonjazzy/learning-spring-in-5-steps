package com.learning.spring.basics.componentscan;		// Component scan will scan this package and everything under it for this application context

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.learning.spring.basics.componentscan")	//Use this to add ay other package. The import alone wont work
@ComponentScan	//Use this to add ay other package. The import alone wont work
public class ComponentScanApplication
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

	// have static variables in all caps! This will log to the output screen
	private static Logger LOGGER = LoggerFactory.getLogger(ComponentScanApplication.class);

	public static void main(String[] args)
	{
		//Application Context manages all our Beans!
		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ComponentScanApplication.class);

		//
		ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);

		LOGGER.info("componentDAO:- {}", componentDAO);
	}
}
