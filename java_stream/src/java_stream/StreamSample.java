package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample {

	public static void main(String[] args) {
		
		/* Stream 객체 만드는 기본 방법
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Stream<Integer> numberStream = numbers.stream();
		Stream<Integer> newNumberStream = Stream.of(1,2,3,4,5,6,7,8,9,10);
		*/
		
		/*
		 * Intermediate Operations
		 */
		
		// Map()
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		List<Integer> cubedNumbers= numbers.stream()
		        .map(x -> x*x*x)
		        .collect(Collectors.toList());
		
		System.out.println("=================================================================");
		System.out.println("Map 결과 : " + cubedNumbers);
		System.out.println("=================================================================");
		
		// FlatMap()
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(4,5,6);
		List<Integer> list3 = Arrays.asList(7,8,9);

		List<List<Integer>> listOfNumbers = Arrays.asList(list1, list2, list3);

		List<Integer> listOfAllIntegers = listOfNumbers.stream()
		        .flatMap(x -> x.stream())
		        .collect(Collectors.toList());
		
		System.out.println("=================================================================");
		System.out.println("FlatMap 결과 : " + listOfAllIntegers);
		System.out.println("=================================================================");
		
		// FlatMap() 2
		String sentence1 = "This is a";
		String sentence2 = "flatMap example";
		List<String> result = Stream.of(sentence1, sentence2) //Stream<String>
			.flatMap(sentence -> Stream.of(sentence.split(" "))) //Stream<String[]> => Stream<String>
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		
		System.out.println("=================================================================");
		System.out.println("FlatMap 결과2 : " + result);
		System.out.println("=================================================================");
				
		// Filter()
		List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		List<Integer> evenNumbers = numbers2.stream()
		        .filter(x -> x%2 == 0)
		        .collect(Collectors.toList());

		System.out.println("=================================================================");
		System.out.println("Filter 결과 : " + evenNumbers);
		System.out.println("=================================================================");
		
		// Sort()
		List<Integer> numbers3 = Arrays.asList(6,7,8,1,4,5,9,10,2,3);
		List<Integer> sortedList = numbers3.stream()
				.sorted()
				.collect(Collectors.toList());

		System.out.println("=================================================================");
		System.out.println("Sort 결과 : " + sortedList);
		System.out.println("=================================================================");
		
		// Distinct()
		List<String> countries = Arrays.asList("India", "Australia", "SriLanka","Russia", "Australia","SriLanka","India");

		List<String> distinctCountries = countries.stream()
				.distinct()
				.collect(Collectors.toList());

		System.out.println("=================================================================");
		System.out.println("Distinct 결과 : " + distinctCountries);
		System.out.println("=================================================================");
		
		// Peek()
		Stream.of(1,2,3,4,5,6,7,8,9,0)
			.filter(x -> x%2 ==0)
			.peek(e -> System.out.println("Peek 결과 : " + e))
			.collect(Collectors.toList());
		
		Stream.of("one", "two", "three", "four")
        	.filter(e -> e.length() > 3)
        	.peek(e -> System.out.println("Filtered value: " + e))
        	.map(String::toUpperCase)
        	.peek(e -> System.out.println("Mapped value: " + e))
        	.collect(Collectors.toList());
		
		/*
		 * Terminal Operations
		 */
		
		// StartsWith()
		List<String> listOfCountries = Arrays.asList("India", "Indonesia", "Nepal", "Afghanistan");

		List<String> output = listOfCountries.stream()
		        .filter(x-> x.toString().startsWith("I"))
		        .collect(Collectors.toList());

		System.out.println("=================================================================");
		System.out.println("StartsWith 결과 : " + output);
		System.out.println("=================================================================");
		
		// Count()
		List<String> listOfCountries2 = Arrays.asList("India", "Indonesia", "Nepal", "Afghanistan");

		long output2 = listOfCountries2.stream()
		        .filter(x-> x.toString().startsWith("I"))
		        .count();

		System.out.println("=================================================================");
		System.out.println("Count 결과 : " + output2);
		System.out.println("=================================================================");
		
		// AllMatch()
		List<String> listOfCountries3 = Arrays.asList("India", "Indonesia", "Nepal", "Afghanistan");
		// List<String> listOfCountries3 = Arrays.asList("India", "Indonesia", "INepal", "IAfghanistan");

		boolean areAllElementsStartingWithI = listOfCountries3.stream()
		        .allMatch(x -> x.toString().startsWith("I"));

		System.out.println("=================================================================");
		System.out.println("AllMatch 결과 : " + areAllElementsStartingWithI);
		System.out.println("=================================================================");
		
		// AnyMatch()
		List<String> listOfCountries4 = Arrays.asList("India", "Indonesia", "Nepal", "Afghanistan");

		boolean areAllElementsStartingWithI2 = listOfCountries4.stream()
		        .anyMatch(x -> x.toString().startsWith("I"));

		System.out.println("=================================================================");
		System.out.println("AnyMatch 결과 : " + areAllElementsStartingWithI2);
		System.out.println("=================================================================");
		
		// ForEach()
		List<String> listOfCountries5 = Arrays.asList("India", "Indonesia", "Nepal", "Afghanistan");

		listOfCountries5.stream()
        	.filter(x-> x.toString().startsWith("I"))
        	.forEach(System.out::println);

	}

}
