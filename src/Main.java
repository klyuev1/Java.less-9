import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Генерация стрима случайных целых чисел
        List<Integer> randomNumbers = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.toList());

        // 1) Запрос со сбором данных в коллекцию
        List<Integer> collectedList = randomNumbers
                .stream()
                .filter(num -> num % 2 == 0) // фильтр четных чисел
                .map(num -> num * 2) // умножение на 2
                .collect(Collectors.toList()); // сбор в список

        System.out.println("Collected List: " + collectedList);

        // 2) Запрос на подсчет количества (например, простых чисел)
        long primeCount = randomNumbers
                .stream()
                .count();

        System.out.println("Count of Prime Numbers: " + primeCount);

        // 3) Запрос, где применяем редукцию множества значений к одному (например, сумма)
        int sum = randomNumbers
                .stream()
                .reduce(0, Integer::sum);

        System.out.println("Sum of Numbers: " + sum);

        // 4) Просто вывод на консоль
        randomNumbers
                .forEach(System.out::println);

        // 5) Запрос с формированием результата в карту (например, квадраты чисел в качестве ключей)
        Map<Integer, Integer> squaredMap = randomNumbers
                .stream()
                .collect(Collectors.toMap(
                        num -> num,
                        num -> num * num,
                        (existing, replacement) -> existing > replacement ? existing : replacement
                ));

        System.out.println("Squared Map: " + squaredMap);
    }
}