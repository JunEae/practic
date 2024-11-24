import java.util.*;

class NumberList {
    private List<Integer> numbers;

    public NumberList() {
        this.numbers = new ArrayList<>();
    }

    public void addNumbers(String input) {
        String[] inputNumbers = input.split(" ");
        for (String num : inputNumbers) {
            try {
                numbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: '" + num + "' не является целым числом. Игнорирование этого значения.");
            }
        }
    }

    public int getMax() {
        if (numbers.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return Collections.max(numbers);
    }

    public double getAverage() {
        if (numbers.isEmpty()) return 0;
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public List<Integer> getSorted() {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }

    public List<Integer> getUnique() {
        Set<Integer> uniqueSet = new HashSet<>(numbers);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        Collections.sort(uniqueList);
        return uniqueList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public List<Integer> getSortedCombined(NumberList other) {
        Set<Integer> combinedSet = new HashSet<>(this.numbers);
        combinedSet.addAll(other.getNumbers());
        List<Integer> combinedList = new ArrayList<>(combinedSet);
        Collections.sort(combinedList);
        return combinedList;
    }
}