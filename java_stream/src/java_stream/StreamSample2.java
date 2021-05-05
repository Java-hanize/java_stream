package java_stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSample2 {

	public static void main(String[] args) {
		
		// 스트림이 없는 코드
		/*
		List<Car> filteredCars = new ArrayList<>();
		for(Car car : cars) {
		    if("red".equals(car.getColor().toLowerCase())) {
		        filteredCars.add(car);
		    }
		}

		Collections.sort(filteredCars, new Comparator<Car>() {
		    @Override
		    public int compare(Car o1, Car o2) {
		       return o1.getPrice().compareTo(o2.getPrice());
		    }
		});

		List<String> carNames = new ArrayList<>();
		for(Car car : filteredCars) {
		    carNames.add(car.getName());
		}
		*/
		
		// 스트림이 있는 코드
		/*
		List<String> carNames = cars
		        .stream()
		        .filter(car -> "red".equals(car.getColor().toLowerCase()))
		        .sorted(Comparator.comparing(Car::getPrice))
		        .map(Car::getName)
		        .collect(Collectors.toList());
		*/
		
		/*
			Filter: 스트림에서 특정 요소를 제외
			Map: 요소를 다른 요소로 변환
			Limit: 지정된 갯수만큼 잘라낸다.
			Collect: 스트림을 다른 형식으로 변환
			
			6.jpg 참조
		 */
		
		List<String> words = Arrays.asList("Streams", "in", "", " ", "Java");
		List<String> result = words
		        .stream()
		        .filter(val -> !val.isBlank())
		        .map(String::toUpperCase)
		        .limit(2)
		        .collect(Collectors.toList());
		System.out.println(result);
		
		// Code: External iteration vs Internal Iteration
		
		List<String> words2 = Arrays.asList("Life", "is", "wonderful");

		// External foreach iteration
		System.out.print("External iteration (foreach): ");
		
		for(String word: words2) {
		    System.out.print(word + " ");
		}
		
		System.out.println();

		// External iterator iteration
		Iterator<String> iterator = words2.iterator();
		System.out.print("External iteration (iterator) : ");

		while(iterator.hasNext()) {
		    System.out.print(iterator.next() + " ");
		}
		
		System.out.println();

		// Internal iteration
		System.out.println("Internal iteration : ");
		List<String> upperCase = words2.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(upperCase);
	}
	
}
