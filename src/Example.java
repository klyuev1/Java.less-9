import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        // Создание коллекции названий овощей
        List<String> vegetables = Arrays.asList("картошка", "морковь", "брокколи", "помидор", "лук");

        // 1) Выборка овощей с длиной названия более 7 символов
        List<String> longVegetables = vegetables.stream()
                .filter(vegetable -> vegetable.length() > 7)
                .collect(Collectors.toList());
        System.out.println("Овощи с названием более 7 символов: " + longVegetables);

        // 2) Query to convert all vegetable names to uppercase
        List<String> uppercaseVegetables = vegetables.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Заглавные названия овощей: " + uppercaseVegetables);

        // 3) Query to count the number of vegetables starting with the letter 'b'
        long countB = vegetables.stream()
                .filter(vegetable -> vegetable.startsWith("б"))
                .count();
        System.out.println("Количество овощей, начинающихся с 'б': " + countB);

        // 4) Объединение названий всех овощей в одну строку, разделенную запятыми
        String joinedVegetables = vegetables.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Объединенные названия овощей: " + joinedVegetables);

        // 5) Проверка наличия овоща "картошка" в коллекции
        boolean containsPotato = vegetables.stream()
                .anyMatch(vegetable -> vegetable.equals("картошка"));
        System.out.println("Содержит 'картошка': " + containsPotato);
    }
}
