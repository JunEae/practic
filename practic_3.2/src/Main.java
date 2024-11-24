import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        NumberList firstList = new NumberList();
        NumberList secondList = new NumberList();

        String firstInput = inputHandler.getInput("Введите числа для первого списка через пробел: ");
        firstList.addNumbers(firstInput);

        displayResults(firstList, "Первый список");

        String secondInput = inputHandler.getInput("Введите числа для второго списка через пробел: ");
        secondList.addNumbers(secondInput);

        displayResults(secondList, "Второй список");

        List<Integer> combinedSorted = firstList.getSortedCombined(secondList);
        System.out.println("Объединенный список: " + combinedSorted);

    }

    private static void displayResults(NumberList numberList, String listName) {
        System.out.println(listName + ":");

        int max = numberList.getMax();
        if (max == Integer.MIN_VALUE) {
            System.out.println("Список пуст, максимальное число не найдено.");
        } else {
            System.out.println("Максимальное число: " + max);
        }
        System.out.printf("Среднее арифметическое: %.2f%n", numberList.getAverage());
        System.out.println("Отсортированный список: " + numberList.getSorted());
        System.out.println("Уникальные элементы: " + numberList.getUnique());
        System.out.println();
    }
}